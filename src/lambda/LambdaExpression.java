/**
 * Created by zouye on 2016/12/20.
 */
public class LambdaExpression {
    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.process(() -> System.out.println("This is awesome!"));

        IntPredicate even = (int i) -> i % 2 == 0;
        even.test(1000);
    }
}

class Lambda {
    public void process(Runnable r) {
        r.run();
    }
}

interface IntPredicate {
    boolean test(int i);
}
