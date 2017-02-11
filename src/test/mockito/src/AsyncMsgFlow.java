package test.mockito.src;

import java.util.Random;

/**
 * Created by Alanjager on 2017/2/10.
 */
public class AsyncMsgFlow {
    private Message msg;

    private MessageBusImpl messageBus;

    private Trigger trigger;

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public MessageBusImpl getMessageBus() {
        return messageBus;
    }

    public void setMessageBus(MessageBusImpl messageBus) {
        this.messageBus = messageBus;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public void run() throws CustomizeException {
        messageBus.send(msg, new MessageCallback() {

            @Override
            public void success() {
                next();
            }

            @Override
            public void failed() throws CustomizeException {
                throw new CustomizeException("Send failed");
            }
        });
    }

    private void next() {
        System.out.println("Go to next work!");
    }
}
