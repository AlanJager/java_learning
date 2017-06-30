package file;

import java.io.File;

/**
 * Created by AlanJager on 2017/5/19.
 */
public class TestOpenFile {
    public static void main(String[] args) {
        File file = new File("test/", "testsets/fsdfsdf");
        if (file != null) {
            System.out.println("not null");
        }
    }
}
