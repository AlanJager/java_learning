package test.mockito.src;

/**
 * Created by AlanJager on 2017/2/11.
 */
public class MessageBusImpl implements MessageBus {
    @Override
    public void send(Message message, MessageCallback messageCallback) throws CustomizeException {
        if(send(message)) {
            messageCallback.success();
        } else {
            messageCallback.failed();
        }
    }

    private boolean send(Message message) {
        System.out.println("[DEBUG] The msg #" + message.getCounter() + " is sent");
        return message.getCounter() % 10 == 0;
    }
}
