package stringTest;

/**
 * Created by xianpeng.xia
 * on 2019/12/23 10:00 下午
 */
public class StringReplace {

    public static void main(String[] args) {
        String clazz = "com.example.test";
        String path1 = clazz.replace(".", "\\");
        System.out.println(path1);

        String path2 = clazz.replaceAll("\\.", "\\\\");
        System.out.println(path2);
    }
}
