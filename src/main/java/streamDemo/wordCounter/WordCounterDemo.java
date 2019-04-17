package streamDemo.wordCounter;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by xianpeng.xia
 * on 2019-04-10 23:02
 */
public class WordCounterDemo {


    public static void main(String[] args) {
        final String SENTENCE =
            " Nel   mezzo del cammin  di nostra  vita " +
                "mi  ritrovai in una  selva oscura" +
                " ché la  dritta via era   smarrita ";
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
            .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream.parallel()) + " words ");

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream1 = StreamSupport.stream(spliterator,true);
        System.out.println("found " + countWords(stream1)+" worlds ");
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
            WordCounter::accumulate,
            WordCounter::combine);
        return wordCounter.getCounter();

    }
}
