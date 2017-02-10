/**
 * Created by AlanJager on 2016/12/1.
 */
public class StaticTest {
    public static void main(String[] args) {
        ForStaticVariable class1 = new ForStaticVariable();
        ForStaticVariable class2 = new ForStaticVariable();

        System.out.println("static_i of class1 is: " + class1.get_static_i());
        System.out.println("instance_i of class1 is: " + class1.get_instance_i());

        class1.increase_static_i();
        class1.increase_instance_i();

        System.out.println("after increase static_i of class1 is: " + class1.get_static_i());
        System.out.println("after increase instance_i of class1 is: " + class1.get_instance_i());

        System.out.println("after increase static_i of class2 is: " + class2.get_static_i());
        System.out.println("after increase instance_i of class2 is: " + class2.get_instance_i());
    }

    static class StaticClass {


        static void main() {
            new StaticTest().say();
        }
    }

    public void say() {
        System.out.println("I'm the StaticTest class");
    }

    class innerClass {
        static final int i = 0;

        public void say() {
            System.out.println("This is a inner class");
        }
    }
}

class ForStaticVariable {
    private static int static_i = 1;
    private int instance_i = 1;

    public int get_static_i() {
        return static_i;
    }

    public int get_instance_i() {
        return instance_i;
    }

    public void increase_static_i() {
        static_i++;
    }

    public void increase_instance_i() {
        this.instance_i++;
    }
}

class ForStaticCodeBlock {
    static{
        System.out.println("This is static code block.");
    }

    {
        System.out.println("This is non-static block.");
    }

    public static void main(String[] args) {
        ForStaticCodeBlock class1 = new ForStaticCodeBlock();
        ForStaticCodeBlock class2 = new ForStaticCodeBlock();
    }
}