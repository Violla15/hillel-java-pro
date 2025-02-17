package ua.ithillel.homeworks.homework5.storage;

import ua.ithillel.homeworks.homework5.car.Car;

import java.util.ArrayList;
import java.util.List;

public class WarehouseStorage implements CarStorage {
    private List<Car> warehouse;

    public WarehouseStorage() {
        this.warehouse = new ArrayList<>();
    }

    public List<Car> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Car> warehouse) {
        this.warehouse = warehouse;
    }

    public void addCar(Car car) {
        this.warehouse.add(car);
    }

    @Override
    public void showStorageCars() {
        System.out.println("Stay in the warehouse storage :");
        for (Car car : warehouse) {
            System.out.println(car.toString());
        }
    }
}
