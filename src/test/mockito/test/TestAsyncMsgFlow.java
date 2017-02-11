import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import test.mockito.src.*;

/**
 * Created by AlanJager on 2017/2/11.
 */
public class TestAsyncMsgFlow {

    @InjectMocks
    AsyncMsgFlow asyncMsgFlow;

    @Mock
    MessageBusImpl messageBus;

    @Mock
    Message message;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSuccess() throws CustomizeException {
        message = new Message();
        message.setCounter(10);
        messageBus = new MessageBusImpl();

        asyncMsgFlow = new AsyncMsgFlow();
        asyncMsgFlow.setMessageBus(messageBus);
        asyncMsgFlow.setMsg(message);
        asyncMsgFlow.setTrigger(new Trigger());
        asyncMsgFlow.run();
    }

    @Test(expected = CustomizeException.class)
    public void testFailed() throws CustomizeException {
        message = new Message();
        message.setCounter(9);
        messageBus = new MessageBusImpl();

        Trigger trigger = new Trigger();

        asyncMsgFlow = new AsyncMsgFlow();
        asyncMsgFlow.setMessageBus(messageBus);
        asyncMsgFlow.setMsg(message);
        asyncMsgFlow.setTrigger(trigger);
        asyncMsgFlow.run();
    }
}
