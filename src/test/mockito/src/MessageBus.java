package test.mockito.src;

/**
 * Created by AlanJager on 2017/2/11.
 */
public interface MessageBus {
    public void send(Message message, MessageCallback messageCallback) throws CustomizeException;
}
