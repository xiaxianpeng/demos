package jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @date 2020/08/10
 * @time 14:02
 */
public class JolTest {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        System.out.println("----------------------------------------");
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        System.out.println("----------------------------------------");
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }
}
