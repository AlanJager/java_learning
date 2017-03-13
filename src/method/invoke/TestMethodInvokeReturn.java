package method.invoke;

/**
 * Created by zouye on 2017/3/13.
 */
public class TestMethodInvokeReturn {
    public static void main(String[] args) {
        TestMethodInvokeReturn testMethodInvokeReturn = new TestMethodInvokeReturn();
        testMethodInvokeReturn.method1();
        testMethodInvokeReturn.method2();
    }

    public void method1() {
        System.out.println("Invoke method 1");
        return;
    }

    public void method2() {
        System.out.println("Invoke method 2");
    }
}
