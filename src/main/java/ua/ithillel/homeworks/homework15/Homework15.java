package ua.ithillel.homeworks.homework15;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Homework15 {
    public static void main(String[] args) {
        Consumer<Container> consumer1 = container -> System.out.println("Container with weight " + container.getWeight() + " wos boarded");
        Consumer<Container> consumer2 = container -> System.out.println("Container goes to " + container.getCountry());

        consumer1.andThen(consumer2).accept(new Container(500, "Italy"));

        Predicate<Container> isBigWeight = container -> container.getWeight() > 100;
        System.out.println(isBigWeight.test(new Container(3000, "USA")));
        System.out.println(isBigWeight.test(new Container(70, "Ukraine")));

        List<Container> containerList = Arrays.asList(new Container(500, "USA"),
                new Container(40, "Germany"),
                new Container(300, "Italy"),
                new Container(40, "Italy"));
        List<String> countryList = new ArrayList<>();
        for (Container s : containerList) {
            countryList.add(s.getCountry());
        }

        Map<String, Long> map = countryList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        Optional<String> mostFrequentMetCountry = map.entrySet().stream()
                .max(comparingByValue())
                .map(Map.Entry::getKey);
        System.out.println(mostFrequentMetCountry);

    }
}