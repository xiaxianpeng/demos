package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 夏先鹏
 * @date 2019/09/16
 * @time 16:21
 *
 * 使用 toArray 带参方法，数组空间大小的 length:
 * 1) 等于 0，动态创建与 size 相同的数组，性能最好。
 * 2) 大于 0 但小于 size，重新创建大小等于 size 的数组，增加 GC 负担。
 * 3) 等于 size，在高并发情况下，数组创建完成之后，size 正在变大的情况下，负面影响与上相同。
 * 4) 大于 size，空间浪费，且在 size 处插入 null 值，存在 NPE 隐患。
 */
public class ListArray {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list2Array(list);

        String[] arary = new String[]{"c", "d"};
        array2List(arary);
    }

    /**
     * 使用 toArray 带参方法，数组空间大小的 length:
     * 1) 等于 0，动态创建与 size 相同的数组，性能最好。
     * 2) 大于 0 但小于 size，重新创建大小等于 size 的数组，增加 GC 负担。
     * 3) 等于 size，在高并发情况下，数组创建完成之后，size 正在变大的情况下，负面影响与上相同。
     * 4) 大于 size，空间浪费，且在 size 处插入 null 值，存在 NPE 隐患。
     */
    private static String[] list2Array(List<String> list) {
        String[] array = list.toArray(new String[0]);
        return array;
    }

    /**
     * asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配器模式，只是转换接口，后台的数据仍是数组。
     */
    private static List<String> array2List(String[] array) {
        List<String> strings = Arrays.asList(array);
        return strings;
    }
}
