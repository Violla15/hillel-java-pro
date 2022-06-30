package ua.ithillel.homeworks.homework5.storage;

import ua.ithillel.homeworks.homework5.car.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StorageInTheParkingLot implements SowStorageCars {
    private List<Car> parking;

    public StorageInTheParkingLot() {
        this.parking = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.parking.add(car);
    }


    public List<Car> getParking() {
        return parking;
    }

    public void setParking(List<Car> parking) {
        this.parking = parking;
    }

    public void showStorageCars() {
        System.out.println("Stay in the parking lot : ");
        Iterator ir = parking.iterator();
        while (ir.hasNext()) {
            System.out.println(ir.next());
        }
    }
}


