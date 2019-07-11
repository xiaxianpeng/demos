package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xianpeng.xia
 * on 2019-07-12 01:54
 */
public class MatchesTest {

    public static void main(String[] args) {
        String[] mails = {
            "11231@qq.com",
            "fadas@163.com",
            "kong@car.org",
            "asd@fg.xasdx"
        };
        String regStr = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = pattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            System.out.println("mail is a legal maill address :" + matcher.matches());
        }
    }
}
