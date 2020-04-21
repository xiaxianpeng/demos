package sort;

/**
 * @date 2020/04/21
 * @time 15:16
 */
public class Sort {

    /**
     * 冒泡排序
     */
    void BubbleSort(int[] array) {

        for (int pass = array.length ; pass >= 0; pass--) {

            for (int i = 0; i < pass - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

        }
    }

    void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 3, 3, 55, 45, 33, 12, 76, 11, 56, 57, 15};
        Sort sort = new Sort();
        sort.display(array);
        sort.BubbleSort(array);
        sort.display(array);
    }
}
