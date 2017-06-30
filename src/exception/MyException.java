package exception;

/**
 * Created by zouye on 2017/4/24.
 */
public class MyException {
    public static void main(String[] args) throws Exception {
        throw new TestException();
    }
}

class TestException extends Exception {

}

class AnotherException extends Exception {

}