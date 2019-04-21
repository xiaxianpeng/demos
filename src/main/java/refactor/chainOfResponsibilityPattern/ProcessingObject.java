package refactor.chainOfResponsibilityPattern;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by xianpeng.xia
 * on 2019-04-21 19:47
 */
public class ProcessingObject {

    public static void main(String[] args) {
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result = pipeline.apply("Are't labda really sexy?!!");
        System.out.println(result);
    }

}
