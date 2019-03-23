package java8_stream;

import java8_stream.bean.Dish;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamDemo {
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
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());

        System.out.println(dishes);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);


        String[] words = {"hello", "world"};
        Stream<String> wordsStream = Arrays.stream(words);

        List<String> uniqueCharacters = title
                .stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sqares = numbers
                .stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println(sqares);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);

        List<int[]> pairs = numbers1
                .stream()
                .flatMap(i -> numbers2
                        .stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());

        for (int[] pair : pairs) {
            System.out.println("(" + pair[0] + "," + pair[1] + ")");
        }


        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("has vegetarian");
        }

        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        isHealthy = menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println(isHealthy);

        Optional<Dish> dish = menu
                .stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish);

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> fitstNumber = someNumbers
                .stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();
        System.out.println(fitstNumber);

        int sum = someNumbers
                .stream()
                .reduce(0, (a, b) -> a + b);

        int sum1 = someNumbers.stream().reduce(0, Integer::sum);
        Optional<Integer> sum2 = someNumbers.stream().reduce(Integer::sum);
        System.out.println(sum2);


        Optional<Integer> max = someNumbers.stream().reduce(Integer::max);
        System.out.println("max: " + max);

        Long count = menu.stream().count();
        System.out.println("count" + count);

        int sum3 = someNumbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("sum " + sum2);

        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("calories = " + calories);

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        IntStream evenNumbers2 = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers2.count());
    }
}
