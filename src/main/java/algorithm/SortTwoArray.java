package algorithm;

/**
 * @author 夏先鹏
 * @date 2019/07/30
 * @time 20:34
 *
 *
 * 给定两个有序整数数组num1和num2，将num2合并到num1中，使得num1为有序数组
 */
public class SortTwoArray {

    private static int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
    private static int[] num2 = new int[]{2, 5, 6};
    private static int m = 3;
    private static int n = 3;
    private static int[] out = new int[]{1, 2, 2, 3, 5, 6};

    public static void main(String[] args) {
        merge(num1, m, num2, n);
        method2(num1, m, num2, n);

        method1(num1, m, num2, n);
    }

    /**
     * 双指针，从前到后
     */
    private static int[] method1(int[] num1, int m, int[] num2, int n) {
        int[] num1_copy = new int[m];
        System.arraycopy(num1, 0, num1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            num1[p++] = (num1_copy[p1] < num2[p2]) ? num1_copy[p1++] : num2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(num1_copy, p1, num1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(num2, p2, num1, p1 + p2, m + n - p1 - p2);
        }
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
        return num1;
    }

    /**
     * 双指针，从后到前
     */
    private static int[] method2(int[] num1, int m, int[] num2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            num1[p--] = (num1[p1] < num2[p2]) ? num2[p2--] : num1[p1--];
        }
        System.arraycopy(num2, 0, num1, 0, p2 + 1);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
        return num1;
    }

}
