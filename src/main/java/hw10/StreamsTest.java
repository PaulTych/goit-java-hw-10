package hw10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Alex");
        names.add("Peter");
        names.add("John");
        names.add("Bill");
        System.out.println("----------------------Task1----------------------------");
        FunctionMethods functions = new FunctionMethods();
        System.out.println(functions.getOddNames(names));

        System.out.println("----------------------Task2----------------------------");
        System.out.println(functions.sortUpperCase(names));

        System.out.println("----------------------Task3----------------------------");
        String[] numbers = {"1, 2, 0", "4, 5"};
        System.out.println(functions.joinElements(numbers));

        System.out.println("----------------------Task4----------------------------");
        functions.random(25214903917L, 11, (long) Math.pow(2, 48), 10L).limit(3).forEach(System.out::println);

        System.out.println("----------------------Task5----------------------------");
        Stream<Integer> numbers1 = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        Stream<Integer> numbers2 = Stream.of(-7, -8, -9, 0, 5, 12);
        System.out.println(functions.zip(numbers1, numbers2).collect(Collectors.toList()));


    }
}
