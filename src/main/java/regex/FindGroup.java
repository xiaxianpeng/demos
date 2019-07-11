package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xianpeng.xia
 * on 2019-07-12 01:27
 */
public class FindGroup {

    public static void main(String[] args) {
        String str = "my phone is : 18288889999," +
            "tom's phone is : 12325686899" +
            "jack's phone is : 15656353215";
        Matcher matcher = Pattern.compile("((12\\d)|(15\\d))\\d{8}").matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
