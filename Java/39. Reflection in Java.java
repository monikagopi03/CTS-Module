import java.lang.reflect.*;

public class ReflectionDemo {
    public void hello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectionDemo");
        Method[] methods = cls.getDeclaredMethods();

        System.out.println("Methods:");
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        Object instance = cls.getDeclaredConstructor().newInstance();
        Method helloMethod = cls.getDeclaredMethod("hello", String.class);
        helloMethod.invoke(instance, "Monika");
    }
}
