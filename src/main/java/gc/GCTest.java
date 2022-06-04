package gc;

/**
 *
 */
public class GCTest {
    public static GCTest obj;

    /**
     * 避免使用 finalize()，操作不当导致产生问题
     * finalize() 优先级低，何时调用无法确定，因为GC时间不确定
     * 建议使用try...catch...finally 来替代finalize()
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 被调用了");
        obj = this;
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new GCTest();
        obj = null;
        System.gc();

        Thread.sleep(1000L);
        // finalize()重新赋值
        if (obj == null) {
            System.out.println("obj == null");
        } else {
            System.out.println("obj 可用");
        }


        Thread.sleep(1000L);
        obj = null;
        System.gc();
        // 已经执行过finalize()，直接回收
        if (obj == null) {
            System.out.println("obj == null");
        } else {
            System.out.println("obj 可用");
        }

    }
}
