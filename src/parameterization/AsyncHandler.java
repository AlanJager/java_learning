package parameterization;


import test.mockito.src.Message;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

/**
 * Created by AlanJager on 2017/2/11.
 */
public class AsyncHandler {

    private int counter;

    private BlockingQueue<Message> queue;

    private volatile boolean handleFinish;

    private volatile boolean sendFinish;

    public AsyncHandler() {
        counter = 0;
        queue = new LinkedBlockingQueue<Message>();
        handleFinish = false;
        sendFinish = false;
    }

    public void handle() {
        new Thread( () -> {
            while (!handleFinish) {
                try {
                    sleep(3);
                } catch (InterruptedException e1) {
                    // 不做处理.
                }
                Message msg = queue.peek();
                if (msg != null) {
                    queue.poll();
                }
                // 若队列为空并且消息发送完成.
                if (queue.isEmpty() && sendFinish) {
                    // 计数器1->0
                    counter++;
                    // 让处理过程结束.
                    handleFinish = true;
                    break;
                }
            }
        }).start();
    }

    public boolean isSendFinish() {
        return sendFinish;
    }

    public void setSendFinish(boolean sendFinish) {
        this.sendFinish = sendFinish;
    }

    public void release() {
        if (queue != null) {
            queue.clear();
            queue = null;
        }
    }

    public void send(Message msg) {
        if (msg != null) {
            System.out.println("[DEBUG] msg #" + msg.getCounter() + " is sent");
            queue.add(msg);
        }
    }

    public static void main(String[] args) {
        ArrayList<Message> msgs = new ArrayList<Message>();
        AsyncHandler handler = new AsyncHandler();
        handler.handle();

        for(int i = 0; i < 100000; i++ ) {
            Message message = new Message();
            message.setCounter(i);
            message.setDescriptor(String.valueOf(i));
            msgs.add(message);
        }

        for (Message m : msgs) {
            handler.send(m);
        }

        handler.setSendFinish(true);
        handler.release();
    }
}
