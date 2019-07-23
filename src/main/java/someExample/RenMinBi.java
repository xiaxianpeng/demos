package someExample;

/**
 * Created by xianpeng.xia
 * on 2019-05-31 16:19
 */
public class RenMinBi {

    private static final char[] data = new char[]{'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    private static final char[] units = new char[]{'元', '拾', '百', '千', '万', '拾', '百', '千', '亿'};

    public static void main(String[] args) {
        System.out.println(convert(132423));

    }

    public static String convert(int money) {
        StringBuffer sb = new StringBuffer();
        int unit = 0;
        while (money != 0) {
            sb.insert(0, units[unit++]);
            int number = money % 10;
            sb.insert(0, data[number]);
            money /= 10;
        }
        return sb.toString();
    }
}
