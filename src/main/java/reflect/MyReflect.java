package reflect;

import java.lang.reflect.Method;

/**
 * @date 2020/04/21
 * @time 09:56
 */
public class MyReflect {

    public static void staticMethod() {
        System.out.println("static method");
    }

    public void publicMethod() {
        System.out.println("public method");
    }

    private void privateMethod() {
        System.out.println("private method");
    }

    public static void main(String[] args) throws Exception {
        // 调用静态方法
        Class<?> myClass = Class.forName("reflect.MyReflect");
        Method staticMethod = myClass.getMethod("staticMethod");
        staticMethod.invoke(myClass);

        // 调用公共方法
        Object instance = myClass.newInstance();
        Method publicMethod = myClass.getMethod("publicMethod");
        publicMethod.invoke(instance);

        // 调用私有方法
        Method privateMethod = myClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(instance);

    }
}
