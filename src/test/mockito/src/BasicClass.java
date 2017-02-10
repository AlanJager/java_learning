package test.mockito.src;

import java.util.ArrayList;

/**
 * Created by Alanjager on 2017/2/10.
 */
public class BasicClass {
    private DatabaseFacase databaseFacase;

    public BasicClass() {
        databaseFacase = new DatabaseFacase();
    }

    public void run() {
        String s = databaseFacase.createQuery("this is a query");

        ArrayList<String> retval = databaseFacase.doQuery(s);

        if (retval.isEmpty()) {
            try {
                throw new CustomizeException("query empty error");
            } catch (CustomizeException e) {
                e.printStackTrace();
            }
        } else {
            finish();
        }
    }

    private void finish() {
        System.out.println("success");
    }
}
