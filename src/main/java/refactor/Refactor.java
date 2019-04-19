package refactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xianpeng.xia
 * on 2019-04-18 08:47
 *
 * 使用 lambda表达式 进行重构
 */
public class Refactor {

    public static void main(String[] args) throws IOException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        Runnable r2 = () -> {
            System.out.println("hello");
        };

        String oneLine = processFile((BufferedReader b) -> b.readLine());
        String twoLine = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println("one line : " + oneLine);
        System.out.println("two line : " + twoLine);

    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/roger/own/demos/demos.iml"))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {

        String process(BufferedReader b) throws IOException;
    }
}
