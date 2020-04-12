package test;

/**
 * Created by xianpeng.xia
 * on 2020/4/12 11:28 下午
 */
public class StaticCode {

    static String prior = "done";
    static String last = f() ? g() : prior;

    public static boolean f() {
        return true;
    }

    public static String g() {
        return "hello word";

    }

    static {
        System.out.println(last);
        g();
    }

    public static void main(String[] args) {
        new StaticCode();
    }
}
