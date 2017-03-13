package integer;

import java.sql.Timestamp;

/**
 * Created by AlanJager on 2017/3/13.
 */
public class IntegerRange {
    public static void main(String[] args) {
        System.out.println(86400L * 400L * 1000L + new Timestamp(System.currentTimeMillis()).getTime());
        System.out.println(new Timestamp((86400L * 400L * 1000L + new Timestamp(System.currentTimeMillis()).getTime())).toString());
        System.out.println(new Timestamp(2147454847000L).toString());
        System.out.println(86400L * 400L * 100000L);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(3456000000000L > (long)Integer.MAX_VALUE * 1000L);
    }
}
//345600000000
//2147454847000
//3456000000000