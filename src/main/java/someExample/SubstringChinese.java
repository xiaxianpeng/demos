package someExample;

/**
 * Created by xianpeng.xia
 * on 2019-05-31 08:27
 */
public class SubstringChinese {

    public static void main(String[] args) {
        String str = "我ABC汉";
        int num = trimGBK(str.getBytes(), 5);
        System.out.println(str.substring(0, num));
        str="abcdef";
        System.out.println(str.substring(0,6));
    }

    public static int trimGBK(byte[] buf, int n) {
        int num = 0;
        boolean bChineseFirstHalf = false;
        for (int i = 0; i < n; i++) {
            if (buf[i] < 0 && !bChineseFirstHalf) {
                bChineseFirstHalf = true;
            } else {
                num++;
                bChineseFirstHalf = false;
            }
        }
        return num;
    }
}
