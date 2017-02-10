package test.mockito.src;

/**
 * Created by Alanjager on 2017/2/10.
 */
public class CustomizeException extends Exception {
    public CustomizeException() {
        super();
    }

    public CustomizeException(Throwable cause) {
        super(cause);
    }

    public CustomizeException(String message) {
        super(message);
    }

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
