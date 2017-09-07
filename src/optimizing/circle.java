package optimizing;

/**
 * Created by AlanJager on 2017/8/13.
 */
public class circle {
    public static void main(String[] args) {
        Test test = new Test();

        int x = 10;
        int y = 100;
        long temp = 0;

        for (long i = test.min(x, y); i < test.max(x, y); i++) {
            temp += test.square(i);
        }

        System.out.println("min invoked " + Test.minTimes + " times");
        System.out.println("max invoked " + Test.maxTimes + " times");
        System.out.println("square invoked " + Test.squareTimes + " times");
    }
}

class Test {
    public static int minTimes = 0;
    public static int maxTimes = 0;
    public static int squareTimes = 0;

    protected long min(long x, long y) {
        minTimes++;
        return x < y ? x : y; }

    protected long max(long x, long y) {
        maxTimes++;
        return x >= y ? x : y; }

    protected long incr(long oldValue, long val) {
        return oldValue += val;
    }

    long square(long x) {
        squareTimes++;
        return x * x;
    }
}
