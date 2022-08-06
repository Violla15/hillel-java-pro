package ua.ithillel.lectures.lecture_15;

import ua.ithillel.lectures.lecture_15.car.Car;
import ua.ithillel.lectures.lecture_15.car.CarSupplier;
import ua.ithillel.lectures.lecture_15.lambda.Greeter;
import ua.ithillel.lectures.lecture_15.lambda.StringFinder;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Lecture15 {
    public static void main(String[] args) {
        List<Car> cars = List.of(new Car("AA881M",
                        207), new Car("", 2006),
                new Car(null, 2012),
                new Car("DF357DF", 2020));

        findNumber(cars, 2010).forEach(System.out::println);

        anonymousClass();

        Greeter greeter = (name, surName) -> name;

        System.out.println(greeter.greet("Name", "SurName"));

        Lecture15 lecture15 = new Lecture15();
        StringFinder stringFinder = lecture15::FindString;
        System.out.println(stringFinder.findString("a","b"));
        lecture15.printCar(Car::new);

        Supplier<Car>carSupplier = () -> new Car("FGJ678HJ",2021);
        System.out.println(carSupplier.get());

        Car car1 = new Car("FHH67",2012);
        Consumer<Car> carConsumer = car -> car.setNumber("DF67GH");
        carConsumer.accept(car1);
        System.out.println(car1);

        Function<Integer,Boolean> isDdd= lecture15::isOdd;
        System.out.println(isDdd.apply(12));

        Predicate<Integer> integerPredicate= integer -> integer>5;
        System.out.println("Greater that 5  "+ integerPredicate.test(6));

    }
    private boolean isOdd(Integer integer){
        return integer%2 ==0;
    }

    public void printCar(CarSupplier carSupplier){
        System.out.println(carSupplier.gat().getNumber()+ ":"+ carSupplier.gat().getYear());
    }

    private int FindString(String str1, String str2) {
        return str1.lastIndexOf(str1);
    }

    private static void anonymousClass() {
        Car car = new Car("AA34566FG", 2015) {

            @Override
            public void print() {
                System.out.println("My custom print method");
            }
        };
        List<Car> cars = List.of(new Car("AA881M", 207),
                new Car("", 2006),
                new Car(null, 2012),
                new Car("DF357DF", 2020));

        cars.forEach(Car::print);
    }


    private static List<String> findNumber(List<Car> cars, int year) {
        return cars.stream()
                .filter(car -> Objects.nonNull(car.getNumber()))
                .filter(car -> !car.getNumber().isEmpty())
                .filter(car -> car.getYear() > year)
                .map(Car::getNumber)
                .collect(Collectors.toList());


    }
}
