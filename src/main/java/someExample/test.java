package someExample;

import java.util.TreeSet;

/**
 * Created by xianpeng.xia
 * on 2019-05-30 23:11
 */
public class test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeSet set = new TreeSet();
        set.add(new Parent(3));
        set.add(new Child());
        set.add(new Parent(4));
        System.out.println(set.toString());
        System.out.println(set.size());
    }

}
