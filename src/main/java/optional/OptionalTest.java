package optional;

import java.util.Optional;
import java.util.Properties;

/**
 * Created by xianpeng.xia
 * on 2019-05-12 22:55
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty();

        //Optional<Car> optionalCar = Optional.of(car);

        //Optional<Car> emptyCar = Optional.ofNullable(car);

        Insurance insurance = new Insurance();

        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);

        System.out.println("name : " + name);

        Optional<Person> optionalPerson = Optional.empty();
        String name1 = getCarInsuranceName(optionalPerson);

        System.out.println("name : " + name1);

        // 找出最便宜的保险公司
        Optional<Car> optionalCar = Optional.empty();
        Optional<Insurance> CheapestInsurance = nullSafeFindCheapestInsurance(optionalPerson, optionalCar);
        System.out.println("CheapestInsurance " + CheapestInsurance);

        // 找出名字为A的保险公司
        optionalInsurance.filter(insurance1 -> "A".equals(insurance.getName()))
            .ifPresent(x -> System.out.println("Exist"));

        //
        Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "true");
        properties.setProperty("c", "-3");

        int duration = readDuration(properties, "c");
        System.out.println("时长： " + duration);
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
            .flatMap(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("unknown");
    }

    public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public static Insurance findCheapestInsurance(Person person, Car car) {
        // TODO ...
        return new Insurance();
    }

    public static int readDuration(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
            .flatMap(s -> stringToInt(s))
            .filter(i -> i > 0)
            .orElse(0);
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
