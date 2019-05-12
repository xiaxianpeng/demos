package optional;

import java.util.Optional;

/**
 * Created by xianpeng.xia
 * on 2019-05-12 22:55
 */
public class OptionalTest {

    Optional<Car> optCar = Optional.empty();

    //Optional<Car> optionalCar = Optional.of(car);

    //Optional<Car> emptyCar = Optional.ofNullable(car);

    Insurance insurance = new Insurance();

    Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
    Optional<String> name = optionalInsurance.map(Insurance::getName);

}
