package ua.ithillel.homeworks.homework16;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Homework16 {
    public static void main(String[] args) {
        System.out.println("Generation of join letters of the English alphabet : ");
        List<String> listOfEnglishAlphabet = new Random().ints(100, 97, 123)
                .mapToObj(i -> (char) i + "")
                .peek(System.out::print).toList();

        System.out.println("\n\nThe most frequent letter in the list : ");
        System.out.println(listOfEnglishAlphabet.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().max(Comparator.comparingLong(Map.Entry::getValue)));

        System.out.println("\nAll letters in the list in sorted order : ");
        listOfEnglishAlphabet.stream().sorted().forEach(System.out::print);

        System.out.println("\n\nAll letters in the list in sorted order from the end of the alphabet : ");
        listOfEnglishAlphabet.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);

    }
}
