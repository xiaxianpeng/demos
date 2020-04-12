package test;

/**
 * Created by xianpeng.xia
 * on 2020/4/12 10:45 下午
 */
public class ParamPassing {

    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuffer stringBufferStatic = new StringBuffer("old stringBuffer");

    public static void main(String[] args) {
        method(intStatic);
        method(stringStatic);
        method(stringBufferStatic, stringBufferStatic);

        System.out.println(intStatic);

        method();

        System.out.println(intStatic);

        System.out.println(stringStatic);
        System.out.println(stringBufferStatic);
    }

    public static void method(int intStatic) {
        intStatic = 777;
    }

    public static void method() {
        intStatic = 888;
    }

    public static void method(String stringStatic) {
        stringStatic = "new string";
    }

    public static void method(StringBuffer stringBufferStatic1, StringBuffer stringBufferStatic2) {
        stringBufferStatic1.append(".method.first-");
        stringBufferStatic2.append("method.second-");

        stringBufferStatic1 = new StringBuffer("new stringBuffer");
        stringBufferStatic1.append("new method's append");
    }
}
