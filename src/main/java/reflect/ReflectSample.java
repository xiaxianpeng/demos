package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @date 2021/03/01
 * @time 13:52
 */
public class ReflectSample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取class
        Class robotClass = Class.forName("reflect.Robot");
        Robot robot = (Robot) robotClass.newInstance();

        System.out.println("Class name is " + robotClass.getName());
        // 调公共方法方式1
        robot.sayHi("bob");
        // 调公共方法方式2
        Method sayHiMethod = robotClass.getMethod("sayHi", String.class);
        sayHiMethod.invoke(robot, "Welcome");

        // 调私有方法
        Method throwHelloMethod = robotClass.getDeclaredMethod("throwHello", String.class);
        throwHelloMethod.setAccessible(true);
        Object str = throwHelloMethod.invoke(robot, "Bob");
        System.out.println("throwHello method result is : " + str);

        // 获取属性
        Field nameField = robotClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(robot, "Alice");

        sayHiMethod.invoke(robot, "Welcome");
    }
}
