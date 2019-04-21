package refactor.observerPattern;

/**
 * Created by xianpeng.xia
 * on 2019-04-21 00:02
 */
public interface Subject {

    void registerOberver(Observer o);

    void notifyObservers(String tweet);

}
