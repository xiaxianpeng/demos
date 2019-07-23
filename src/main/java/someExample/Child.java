package someExample;

/**
 * Created by xianpeng.xia
 * on 2019-05-30 23:11
 */
public class Child extends Parent {

    public Child() {
        super(3);
    }

    public int compareTo(Object o) {

        // TODO Auto-generated method stub
        System.out.println("method of child");
//         Child o1 = (Child)o;
        return 1;

    }

    @Override
    public String toString() {
        return "child age = " + getAge();
    }
}
