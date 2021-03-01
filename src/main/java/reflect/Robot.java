package reflect;

/**
 * @date 2021/03/01
 * @time 13:49
 */
public class Robot {

    private String name;

    public void sayHi(String helloSentence) {
        System.out.println(helloSentence + " " + name);
    }

    private String throwHello(String tag) {
        return "Hello " + tag;
    }
}
