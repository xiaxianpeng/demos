package java8_stream;

import java8_stream.bean.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class menu {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        //
        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(d -> d.getCalories() > 450)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);

        List<String> title = Arrays.asList("1", "s", "asd");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        //s.forEach(System.out::println);

        List<Dish> dishes = menu.stream()
        .filter(dish -> dish.getCalories()>300)
        .skip(2)
        .collect(toList());

        System.out.println(dishes);

    }
}
