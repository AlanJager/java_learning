import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import test.mockito.src.DatabaseFacase;

/**
 * Created by AlanJager on 2017/2/11.
 */
public class TestDatabaseFacase {

    @InjectMocks
    private DatabaseFacase databaseFacase;

    @Before
    public void setUp() {
        databaseFacase = new DatabaseFacase();
    }

    @Test
    public void testCreateQuery() {
        databaseFacase.createQuery("test");
    }

}
