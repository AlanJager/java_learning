import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

/**
 * Created by zouye on 2017/3/2.
 */
public class MvelConcurrencyTest {
    public static String[] paths = {"test", "test"};

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    test3();
                }).start();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    test3();
                }).start();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    test3();
                }).start();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    test3();
                }).start();
            }
        }).start();
    }

    public static void test3() {
        Map vars = new HashMap();
        vars.put("x", 4);
        vars.put("y", 5);

        Serializable compiled = MVEL.compileExpression("x + y");
        Integer result = (Integer) MVEL.executeExpression(compiled, vars);
    }
}
