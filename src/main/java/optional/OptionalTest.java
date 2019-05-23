package optional;

import java.util.Optional;

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
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
            .flatMap(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("unknown");
    }

}
