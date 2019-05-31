package someExample;

/**
 * Created by xianpeng.xia
 * on 2019-05-30 23:10
 */
public class Parent implements Comparable {
    private int age = 0;
    public Parent(int age){
        this.age = age;
    }
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        System.out.println("method of parent");
        Parent o1 = (Parent)o;
        return age>o1.age?1:age<o1.age?-1:0;
    }

    @Override
    public String toString() {
        return "parent age = "+age;
    }
    public int getAge(){
        return this.age;
    }
}
