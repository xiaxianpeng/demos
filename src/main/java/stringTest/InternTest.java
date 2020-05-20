package stringTest;

/**
 * @date 2020/05/20
 * @time 15:41
 */
public class InternTest {

    public static void main(String[] args) {
        String s0 = "k";
        String s1 = new String("k");
        String s2 = new String("k");

        System.out.println(s0 == s1);
        System.out.println("--------------");
        s1.intern();
        s2 = s2.intern();
        System.out.println(s0 == s1);
        System.out.println(s0 == s1.intern());
        System.out.println(s0 == s2);
    }
}
