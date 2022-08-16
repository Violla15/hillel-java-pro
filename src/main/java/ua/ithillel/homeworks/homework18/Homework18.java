package ua.ithillel.homeworks.homework18;

import ua.ithillel.homeworks.homework18.convert.ConvertCarToXML;
import ua.ithillel.homeworks.homework18.entity.Car;

import ua.ithillel.homeworks.homework18.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

public class Homework18 {
    public static List<Car> cars = new ArrayList<>();
    public static final String fileName = "src/main/java/ua/ithillel/homeworks/homework18/files/carsWithLocation.xml";

    public static void main(String[] args) {

        jsonCarsParser();

        convertObjectToXml();
    }

    private static void jsonCarsParser() {
        JSONParser jsonCarParser = new JSONParser();
        jsonCarParser.parseCar("src/main/java/ua/ithillel/homeworks/homework18/files/cars.json", cars);
    }

    private static void convertObjectToXml() {
        ConvertCarToXML carToXML = new ConvertCarToXML();
        carToXML.convertCarToXml(cars, fileName);
    }
}

