package loader;

/**
 * @author 夏先鹏
 * @date 2019/07/05
 * @time 17:28
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader loader = Test.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}
