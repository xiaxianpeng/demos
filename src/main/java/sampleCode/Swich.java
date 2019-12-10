package sampleCode;

/**
 * @author 夏先鹏
 * @date 2019/09/16
 * @time 20:51
 */
public class Swich {

    public static void main(String[] args) {
        method(null);
    }

    public static void method(String param) {
        switch (param) {
            case "a":
                System.out.println("it is a");
                break;
            case "null":
                System.out.println("it is null");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
