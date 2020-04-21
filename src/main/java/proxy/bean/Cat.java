package proxy.bean;

/**
 * @date 2020/04/21
 * @time 10:33
 */
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("The cat is eating");
    }
}
