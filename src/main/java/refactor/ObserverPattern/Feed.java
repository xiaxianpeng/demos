package refactor.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianpeng.xia
 * on 2019-04-21 00:04
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerOberver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerOberver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY ! " + tweet);
            }
        });
        feed.registerOberver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London ! " + tweet);
            }
        });

        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
