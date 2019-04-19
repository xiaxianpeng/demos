package refactor.strategyPattern;

/**
 * Created by xianpeng.xia
 * on 2019-04-19 23:24
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {

        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean b1 = numericValidator.validate("a1a");
        System.out.println("if all number : " + b1);
        Validator lowerCaseValidator = new Validator((s) -> s.matches("[a,z]++"));
        boolean b2 = lowerCaseValidator.validate("aVb");
        System.out.println("if all lower char : " + b2);

    }
}
