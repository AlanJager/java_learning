package test.mockito.src;

/**
 * Created by AlanJager on 2017/2/11.
 */
public interface MessageCallback {
    public void success();

    public void failed() throws CustomizeException;
}
