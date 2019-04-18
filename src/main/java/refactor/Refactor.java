package refactor;

/**
 * Created by xianpeng.xia
 * on 2019-04-18 08:47
 */
public class Refactor {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        Runnable r2 = () -> {
            System.out.println("hello");
        };

    }
}
