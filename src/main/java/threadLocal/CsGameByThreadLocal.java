package threadLocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by xianpeng.xia
 * on 2020/4/19 6:56 下午
 */
public class CsGameByThreadLocal {

    /**
     * 初始子弹数
     */
    private static final Integer BULLET_NUMBER = 1500;
    /**
     * 初始杀敌数
     */
    private static final Integer KILLED_ENEMIES = 0;
    /**
     * 剩余生命
     */
    private static final Integer LEFT_VALUE = 10;
    /**
     * 玩家数量
     */
    private static final Integer TOTAL_PLAYERS = 10;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };

    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };

    private static final ThreadLocal<Integer> LEFT_VALUE_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return LEFT_VALUE;
        }
    };

    private static class Player extends Thread {

        @Override
        public void run() {
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS / 2);
            Integer leftValue = LEFT_VALUE_THREADLOCAL.get() - RANDOM.nextInt(LEFT_VALUE);

            System.out.println(getName() + ",BULLET_NUMBER is : " + bullets);
            System.out.println(getName() + ",KILLED_ENEMIES is : " + killEnemies);
            System.out.println(getName() + ",LEFT_VALUE is : " + leftValue);

            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LEFT_VALUE_THREADLOCAL.remove();

        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }
}
