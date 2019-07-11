package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xianpeng.xia
 * on 2019-07-12 02:11
 */
public class ReplaceTest {

    public static void main(String[] args) {
        String[] strings = {
            "java reasd asda",
            "are read asdaa",
            "reasd adfsre adareasd"
        };
        String regStr = "re\\w*";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = null;

        for (int i = 0; i < strings.length; i++) {
            if (matcher == null) {
                matcher = pattern.matcher(strings[i]);
            } else {
                matcher = matcher.reset(strings[i]);
            }
            System.out.println(matcher.replaceAll("哈哈:)"));
            System.out.println(strings[i]);

        }
    }
}