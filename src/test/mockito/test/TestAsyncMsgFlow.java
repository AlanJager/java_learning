import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.mockito.src.AsyncMsgFlow;
import test.mockito.src.CustomizeException;
import test.mockito.src.Message;
import test.mockito.src.MessageBusImpl;

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

        asyncMsgFlow = new AsyncMsgFlow(message, messageBus);
        asyncMsgFlow.run();
    }

    @Test(expected = CustomizeException.class)
    public void testFailed() throws CustomizeException {
        message = new Message();
        message.setCounter(9);
        messageBus = new MessageBusImpl();

        asyncMsgFlow = new AsyncMsgFlow(message, messageBus);
        asyncMsgFlow.run();
    }
}
