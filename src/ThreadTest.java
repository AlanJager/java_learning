/**
 * Created by zouye on 2016/12/2.
 */
public class ThreadTest {

    /**
     * タイマの実行間隔.
     */
    public static final int TICK_INTERVAL = 40;

    private transient Thread thread;

    public ThreadTest() {
        new Thread() {
            {
                this.setDaemon(true);
                this.start();
            }

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch (final InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        };
    }

    public void start() {

        if ( thread!=null && thread.isAlive() ) {
            // もうスレッドが動いている
            return;
        }

        thread = new Thread() {
            @Override
            public void run() {

                // 前回の時間
                long prev = System.nanoTime() / 1000000;
                try {
                    for (;;) {
                        for (;;) {
                            // 現在の時間
                            // TICK_INTERVAL 経つまでループ.
                            final long cur = System.nanoTime() / 1000000;
                            if (cur - prev >= TICK_INTERVAL) {
                                if (cur > prev + TICK_INTERVAL * 2) {
                                    prev = cur;
                                } else {
                                    prev += TICK_INTERVAL;
                                }
                                break;
                            }
                            Thread.sleep(1, 0);
                        }

                        // マスコットたちを動かす.
                        tick();
                    }
                } catch (final InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        thread.setDaemon(false);

        thread.start();
    }

    /**
     * スレッドを停止する.
     */
    public void stop() {
        if ( thread==null || !thread.isAlive() ) {
            // もう動いていない
            return;
        }

        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * マスコットを一フレーム進める.
     */
    private void tick() {

        System.out.println("invoke tick function");
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
//        threadTest.start();
    }
}
