package regex;

import java.util.regex.Pattern;

/**
 * Created by xianpeng.xia
 * on 2019-07-11 23:37
 */
public class RegexTest {
    /** 正则表达式支持的字符
     * x 字符x代表任何合法字符
     * \0mnn 八进制数0mnn所表示的字符
     * \xhh 十六进制值0xhh表示的字符
     * \\uhhhh 十六进制值0xhhhh表示的unicode字符
     * \t 制表符 "\u0009"
     * \n 换行符 "\u000A"
     * \r 回车符 "\u000D"
     * \f 换页符 "\u000C"
     * \a 报警符 "\u0007"
     * \e Escape符 "\001B"
     * \cx x对应的控制符,\cM 匹配Ctrl-M
     */

    /**
     * 特殊字符
     * $ 匹配一行的结尾，如果要匹配$本身用 \$
     * ^ 匹配一行的开头，如果要匹配^本身用 \^
     * () 标记子表达式的开始和结束位置，要匹配这些字符，请使用 \( , \)
     * [] 用于确定中括号表达式的开始和结束位置，要匹配这些字符，请使用\[ , \]
     * {} 用于标记前面子表达式出现频率，要匹配这些字符，请使用\{ ,\}
     * * 指定前面子表达式可以出现零次或多次，要匹配*本身，用 \*
     * + 指定前面子表达式可以出现零次或多次，要匹配+本身，用 \+
     * ? 指定前面子表达式可以出现零次或一次，要匹配?本身，用\?
     * . 匹配除换行符 \n之外的任何但字符，要匹配.本身，用\.
     * \ 用于转义下一个字符,或指定八进制，十六进制字符,如果要匹配\, 用 \\
     * | 指定两项之间任选一项，如果要匹配|字符本身，使用 \|
     */
    private static String a = "\u0041\\\\";
    private static String aTab = "\u0061\t";
    private static String x = "\\?\\[";


    /**
     * 通配符
     * . 可以匹配任何字符
     * \d 可以匹配0-9所有数字
     * \D 匹配非数字
     * \s 匹配所有空字符串，包括空格，制表符，回车符，换页符，换行符
     * \S 匹配所有的非空白字符
     * \w 匹配所有的单词字符，包括0-9所有数字，26个英文字母和下划线(_)
     * \W 匹配所有的非单词字符
     */
    private static String cXt = "c\\wt";
    private static String ooo_ooo_oooo = "\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";

    /**
     * 方括号表达式
     * 表示枚举 例如[abc] 表示a,b,c 任意字符
     * 表示范围 例如[a-f] 表示a-f范围的字符 范围可与枚举结合　 例如[a-fx-z] 表示a-f，x-z范围的任意字符
     * 表示求否^ 例如[^abc] 表示除a,b,c 任意字符
     * 表示求与&& 例如[a-z&&def] 表示d,e,f;[a-z&&[^bc]] 表示[ad-z];[a-z&&[^m-p]] 表示 [a-lq-z]
     * 表示求并运算 例如[a-d[m-p]] 表示[a-dm-p]
     */

    /**
     * 圆括号用于将多个表达式组成一个表达式，圆括号中可以使用或运算符（|）
     *
     */

    /**
     * 边界符
     *
     * ^ 行的开头
     * $ 行的结尾
     * \b 单词的边界
     * \B 非单词的边界
     * \A 输入的开头
     * \G 前一个匹配的结尾
     * \Z 输入的结尾，仅用于最后的结束符
     * \z 输入的结尾
     */

    /**
     * 数量标识符
     * 1贪婪模式
     * 2勉强模式  后缀？
     * 3占有模式  后缀+
     *
     * 贪婪模式    勉强模式    占有模式    说明
     * X?       X??        X?+      X表达式出现零次或一次
     * X*       X*?        X*+      X表达式出现零次或多次
     * X+       X+?        X++      X表达式出现一次或多次
     * X{n}     X{n}?      X{n}+    X表达式出现n次
     * X{n,}    X{n,}?     X{n,}    X表达式至少出现n次
     * X{n,m}   X{n,m}?    X{n,m}+  X表达式至少出现n次，最多出现m次
     */
    public static void main(String[] args) {
        boolean ifA = Pattern.matches(a, "A\\");
        System.out.println("if A\\ :" + ifA);
        boolean ifaTab = Pattern.matches(aTab, "a" + "\t");
        System.out.println("if aTab  : " + ifaTab);
        boolean ifX = Pattern.matches(x, "?[");
        System.out.println("if x : " + ifX);

        boolean ifcXt = Pattern.matches(cXt, "cat");
        System.out.println("if cXt : " + ifcXt);
        boolean if000_000_0000 = Pattern.matches(ooo_ooo_oooo, "000-000-0000");
        System.out.println("if000_000_0000 :" + if000_000_0000);


    }
}
