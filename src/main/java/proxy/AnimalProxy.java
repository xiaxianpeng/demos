package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import proxy.bean.Animal;
import proxy.bean.Cat;
import proxy.bean.Dog;

/**
 * @date 2020/04/21
 * @time 10:34
 */
public class AnimalProxy implements InvocationHandler {

    // 代理对象
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object result = method.invoke(target, args);
        System.out.println("调用后");
        return result;
    }

    public static void main(String[] args) {
        AnimalProxy animalProxy = new AnimalProxy();
        Animal dogProxy = (Animal) animalProxy.getInstance(new Dog());
        dogProxy.eat();
    }
}
