package reflect;

/**
 * @date 2021/03/01
 * @time 15:36
 */
public class ClassLoaderChecker {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String path = "/Users/michael/Desktop/";
        MyClassLoader myClassLoader = new MyClassLoader(path, "myClassLoader");
        Class c = myClassLoader.loadClass("Wali");
        System.out.println(c.getClassLoader());
        c.newInstance();
    }
}
