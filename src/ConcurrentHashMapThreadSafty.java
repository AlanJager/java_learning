import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by AlanJager on 2016/11/15.
 */
public class ConcurrentHashMapThreadSafty {
    private static Map<Long, Long> widgetCacheMap = new ConcurrentHashMap<Long, Long>();

    public static void main(String[] args)
    {
        for(int i = 0; i < 100000; i++) {
            Thread t = new Thread(new RunnableFuntion());
            t.start();
        }
    }

    static class RunnableFuntion implements Runnable {
        public void run() {
            test();
        }

        public void test() {
            ConcurrentHashMapThreadSafty concurrentHashMapThreadSafty = new ConcurrentHashMapThreadSafty();
            concurrentHashMapThreadSafty.set();
            Long l1 = widgetCacheMap.get(1L);
            concurrentHashMapThreadSafty.change();
            Long l2 = widgetCacheMap.get(2L);

            if (l1 == l2) {
                System.out.println(l1 + ":" + l2);
            }
        }
    }

    public void set() {
        widgetCacheMap.put(1L, 1L);
    }
    public void change(){
        widgetCacheMap.put(1L, 2L);
    }
}
