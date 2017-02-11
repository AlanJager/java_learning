package test.mockito.src;

import java.util.ArrayList;

/**
 * Created by AlanJager on 2017/2/10.
 */
public class DatabaseFacase implements Database{

    @Override
    public String createQuery(String string) {
        return string;
    }

    @Override
    public ArrayList<String> doQuery(String queryString) {
        return new ArrayList<String>();
    }
}
