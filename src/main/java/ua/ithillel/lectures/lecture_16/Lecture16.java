package ua.ithillel.lectures.lecture_16;

import ua.ithillel.lectures.lecture_16.optional.Computer;
import ua.ithillel.lectures.lecture_16.optional.SoundCard;
import ua.ithillel.lectures.lecture_16.optional.USB;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lecture16 {
    public static void main(String[] args) {
        creationOfStream();
        streams();
        optional();
    }

    private static void optional() {
        Computer computer = new Computer();
        SoundCard soundCard = new SoundCard();
        USB usb = new USB();
        usb.setVersion("1.0");
        soundCard.setUsb(usb);
        computer.setSoundCard(soundCard);

        String version = "UNKNOWN";
        if (computer != null) {
            SoundCard sc = computer.getSoundCard();
            if (sc != null) {
                USB u = soundCard.getUsb();
                if (u != null) {
                    version = u.getVersion();
                }
            }
        }

        System.out.println("Version is " + version);

        String versionOptional = Optional.ofNullable(computer)
                .flatMap(computer1 -> Optional.ofNullable(computer1.getSoundCard()))
                .flatMap(soundCard1 -> Optional.ofNullable(soundCard1.getUsb()))
                .map(USB::getVersion)
                .orElse("UNKNOWN");

        System.out.println(versionOptional);

    }

    public static boolean isOdd(Integer integer) {
        return integer % 2 == 0;
    }

    private static void streams() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> oddNumbers = numbers.stream()
                .filter(Lecture16::isOdd)
                .collect(Collectors.toList());

        System.out.println("Odd numbers");
        oddNumbers.forEach(System.out::println);

        List<Integer> randomNumbers = new Random()
                .ints(100, 0, 100)
                .boxed()
                .collect(Collectors.toList());

        randomNumbers.forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        Integer sumOfAllElements = randomNumbers.stream()
                .reduce(Integer::sum)
                .get();

        System.out.println("Sum of all elements = " + sumOfAllElements);

        List<Integer> numbersBiggerThan50 = randomNumbers.stream()
                .filter(integer -> integer > 50)
                .collect(Collectors.toList());

        System.out.println("Bigger than 50 size is " + numbersBiggerThan50.size());

        Set<String> stringSet = numbersBiggerThan50.stream()
                .map(integer -> "[" + integer + "]")
                .collect(Collectors.toSet());

        System.out.println("Mapped numbers");
        stringSet.forEach(System.out::print);
        System.out.println();
    }

    private static void creationOfStream() {
        List<String> stringList = List.of("a", "b", "c");
        Stream<String> stringStream = stringList.stream();

        Stream<? extends Serializable> streamOf = Stream.of("a", 1, 2);

        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4});

        String myString = "ABC";
        IntStream chars = myString.chars();

        Stream.Builder<String> builder = Stream.builder();
        builder.add("A").add("B").add("C").build();

        Stream<String> parallelStream = stringList.parallelStream();

        List<String> strings = stringStream
                .collect(Collectors.toList());

        // stringStream.collect(Collectors.toList());
    }
}

