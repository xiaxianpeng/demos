package streamDemo;

import streamDemo.bean.Trader;
import streamDemo.bean.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class TraderTest {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        List<Transaction> tr2011 = transactions.stream()
            .filter(transaction -> transaction.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());
        System.out.println(tr2011);

        List<String> citys = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .distinct()
            .collect(Collectors.toList());
        System.out.println(citys.toString());

        Set<String> city2 = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .collect(Collectors.toSet());
        System.out.println(city2.toString());

        List<Trader> traders = transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getTrader)
            .distinct()
            .sorted(Comparator.comparing(trader -> trader.getName()))
            .collect(Collectors.toList());
        System.out.println(traders.toString());

        String names = transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .reduce("", (a, b) -> a + b);
        System.out.println(names);

        String traderStr = transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.joining());
        System.out.println(traderStr);

        boolean ifWorkOnMilan = transactions.stream()
            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(ifWorkOnMilan);

        transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .forEach(System.out::println);
        Optional<Integer> maxValue = transactions.stream()
            .map(transaction -> transaction.getValue())
            .reduce(Integer::max);
        System.out.println("max : " + maxValue);

        Optional<Transaction> minValue = transactions.stream()
            .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2
            );
        Optional<Transaction> minVal = transactions.stream()
            .min(Comparator.comparing(Transaction::getValue));
        System.out.println(minVal);

    }
}
