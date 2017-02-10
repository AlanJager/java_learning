import java.util.Random;

public class MicroBenchmark {
//    private static volatile double l;

    public void doTest() {

        int nLoops = 10;
        Random random = new Random(50);
        int[] intput = new int[nLoops];
        double l;

        for (int i = 0; i < nLoops; i++) {
            intput[i] = Math.abs(random.nextInt() % 50) + 1;
            System.out.println(intput[i]);
        }

        long then = System.currentTimeMillis();
        for (int i = 0; i < nLoops; i++) {
            l = (double) calculate(intput[i]);
        }
        long now = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (now - then));
    }

    public double calculate(int i) {
        if (i == 1 || i == 2)
            return 1;
        else
            return calculate(i - 1) + calculate(i - 2);
    }

    public static void main(String[] args) {
        MicroBenchmark microBenchmark = new MicroBenchmark();
        microBenchmark.doTest();
    }
}
