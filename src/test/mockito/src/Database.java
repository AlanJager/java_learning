package test.mockito.src;

import java.util.ArrayList;

/**
 * Created by AlanJager on 2017/2/10.
 */
public interface Database {
    public String createQuery(String string);

    public ArrayList<String> doQuery(String queryString);
}
