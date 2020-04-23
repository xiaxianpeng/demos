package sort;

/**
 * @date 2020/04/21
 * @time 15:16
 */
public class Sort {

    /**
     * 冒泡排序
     */
    void bubbleSort(int[] array) {

        for (int pass = array.length; pass >= 0; pass--) {

            for (int i = 0; i < pass - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

        }
    }

    void bubbleSortImproved(int[] array) {
        boolean swapped = true;

        for (int pass = array.length; pass >= 0 && swapped; pass--) {
            for (int i = 0; i < pass - 1; i++) {
                swapped = false;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
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

    void selection(int[] array) {
        // 1 寻找序列中的最小值
        // 2 用当前位置的值交换最小值
        // 3 对所有元素重复1 2

        int temp, min;
        for (int i = 0; i < array.length; i++) {
            min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }

    }

    void insertionSort(int[] array) {
        /* 1 从第一个元素开始，该元素可以认为已经被排序
           2 取出下一个元素，在已排序的元素序列中从后扫描
           3 如果该元素(已排序）大于新元素，则将该元素移到下一位置
           4 重复步骤3，直到找到已排序的元素小于等于新元素的位置
           5 将新元素插入到该位置后
           6 重复2-5
         */
        int i, j, key;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && (array[j] > key)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 3, 3, 55, 45, 33, 12, 76, 11, 56, 57, 15};
        Sort sort = new Sort();
        sort.display(array);
        // 简单冒泡排序
        //// sort.bubbleSort(array);
        // 改进后的冒泡排序
        //// sort.bubbleSortImproved(array);
        // 选择排序
        //  sort.selection(array);
        //  插入排序
        sort.insertionSort(array);
        sort.display(array);
    }
}
