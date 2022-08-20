package ua.ithillel.homeworks.homework18.parser;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import ua.ithillel.homeworks.homework18.entity.Car;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public void parseCar(String path, List<Car> cars) {
        try {
            Reader reader = new FileReader(path);
            Type listType = new TypeToken<ArrayList<Car>>() {
            }.getType();
            List<Car> carList = new Gson().fromJson(reader, listType);
            cars.addAll(carList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
