import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import test.mockito.src.BasicClass;
import test.mockito.src.CustomizeException;
import test.mockito.src.DatabaseFacase;

import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
/**
 * Created by AlanJager on 2017/2/10.
 */
public class TestBasicClass {

    @InjectMocks
    private BasicClass basicClass;

    @Mock
    private DatabaseFacase databaseFacase;

    @Before
    public void setUp() {
        basicClass = new BasicClass();
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = CustomizeException.class)
    public void testRetvalEmpty() throws CustomizeException {
        when(databaseFacase.createQuery(anyString()))
                .thenReturn("string");

        when(databaseFacase.doQuery(anyString()))
                .thenReturn(new ArrayList<String>());

        basicClass.run(databaseFacase);
    }

    @Test
    public void testResultFinished() throws CustomizeException {
        ArrayList<String> ret = new ArrayList<String>();
        ret.add("test");

        when(databaseFacase.createQuery(anyString()))
                .thenReturn("string");

        when(databaseFacase.doQuery(anyString()))
                .thenReturn(ret);

        basicClass.run(databaseFacase);
    }
}
