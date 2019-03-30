package java8_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VersionSort {

    public static void main(String[] args) {
        List<String> versions = new ArrayList<>();
        versions.add("1.2.2");
        versions.add("1.3.5");
        versions.add("2.3.4");
        versions.add("2.4");
        versions.add("1.2.2.1");
        versions.add("3.4.2");
        versions.add("3.4.2");

        versions.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] v1 = o1.contains(".") ? o1.split("\\.") : new String[]{o1};
                String[] v2 = o2.contains(".") ? o2.split("\\.") : new String[]{o2};
                int length1 = v1.length;
                int length2 = v2.length;
                int min = Math.min(length1, length2);
                for (int i = 0; i < min; i++) {
                    if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                        return -1;
                    }
                    if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                        return 1;
                    }
                }
                return length2 - length1;
            }
        });

        System.out.println(versions);
    }
}
