package hashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by AlanJager on 2017/6/24.
 */
public class AtomicOperationInConcurrentHashMap {
    public static void main(String[] args) {
        Facade facade = new Facade();
        String v1 = "v1";
        String v2 = "v2";

        facade.taskRunning.putIfAbsent(v1, false);
        facade.taskRunning.putIfAbsent(v1, false);

        for (int i = 0 ; i < 10 ; i++) {
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (facade.getVolumeLock(v1)) {
                        System.out.println("Thread" + temp + " get lock of v1");
                        facade.releaseVolumeLock(v1);
                    } else {
                        System.out.println("can not get lock of v1");
                    }
                }
            }).start();
        }

        System.out.println(facade.count);
    }
}

class Facade {
    public ConcurrentHashMap<String, Boolean> taskRunning = new ConcurrentHashMap<>();

    public volatile static int count = 0;

    public boolean getVolumeLock(String volumeUuid) {
        count++;

        return taskRunning.replace(volumeUuid, false, true);
    }

    public boolean releaseVolumeLock(String volumeUuid) {
        return taskRunning.put(volumeUuid, false);
    }
}
