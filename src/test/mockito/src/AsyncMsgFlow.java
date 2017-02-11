package test.mockito.src;

import java.util.Random;

/**
 * Created by Alanjager on 2017/2/10.
 */
public class AsyncMsgFlow {
    private Message msg;

    private MessageBusImpl messageBus;

    public AsyncMsgFlow(Message msg, MessageBusImpl messageBus) {
        this.msg = msg;
        this.messageBus = messageBus;
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
