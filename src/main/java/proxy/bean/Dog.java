package proxy.bean;

/**
 * @date 2020/04/21
 * @time 10:32
 */
public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("The dog is eating");
    }
}
