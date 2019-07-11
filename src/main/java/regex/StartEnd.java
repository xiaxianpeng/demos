package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xianpeng.xia
 * on 2019-07-12 01:40
 */
public class StartEnd {

    public static void main(String[] args) {
        String str = "Java is very easy";
        System.out.println("regex str is : " + str);
        Matcher matcher = Pattern.compile("\\w+").matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group() + " :start " + matcher.start() + " ,end : " + matcher.end());
        }
    }

}
