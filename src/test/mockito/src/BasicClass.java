package test.mockito.src;

import java.util.ArrayList;

/**
 * Created by AlanJager on 2017/2/10.
 */
public class BasicClass {
    public void run(DatabaseFacase databaseFacase) throws CustomizeException {
        String s = databaseFacase.createQuery("this is a query");

        ArrayList<String> retval = databaseFacase.doQuery(s);

        if (retval.isEmpty()) {
            throw new CustomizeException("query empty error");
        } else {
            finish();
        }
    }

    private void finish() {
        System.out.println("success");
    }
}
