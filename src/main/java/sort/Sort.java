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

    void shellSort(int[] array) {
        /*
        1 选择一个增量序列 t1,t2,t3...tk ,其中ti>tj,tk=1;
        2 按赠量序列个数k，对序列进行k趟排序
        3 每趟排序，根据对应的增量ti，将待排序列分割成若干长度m的自序列，
        4 分别对各子表进行直接插入排序，仅增量因子为1时，整个序列当成一个表来处理，表长度即为整个序列的长度
         */
        int gap = 1;
        while (gap < array.length) {
            gap = gap * 3 + 1;
        }
        System.out.println("gap: " + gap);

        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > temp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
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
        // sort.insertionSort(array);
        // 希尔排序
        sort.shellSort(array);
        sort.display(array);
    }
}
