package proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.bean.Panda;

/**
 * @date 2020/04/21
 * @time 10:48
 */
public class CglibProxy implements MethodInterceptor {

    // 要代理的对象
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置父类为实例类
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        // 执行方法调用
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用后");
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Panda panda = (Panda) cglibProxy.getInstance(new Panda());
        panda.eat();
    }
}
