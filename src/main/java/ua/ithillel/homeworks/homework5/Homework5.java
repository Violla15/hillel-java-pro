package ua.ithillel.homeworks.homework5;

import ua.ithillel.homeworks.homework5.car.*;
import ua.ithillel.homeworks.homework5.storage.StorageInTheParkingLot;
import ua.ithillel.homeworks.homework5.storage.WarehouseStorage;

public class Homework5 {
    public static void main(String[] args) {
        StorageInTheParkingLot parkingLot = new StorageInTheParkingLot();
        WarehouseStorage warehouseStorage = new WarehouseStorage();

        SportsCar ferrari = new SportsCar("Ferrari", "2020", 90000, Equipment.SPORT, "Italy", "20.03.2021", "C.C. Petrov", 300, 90, 300);
        parkingLot.addCar(ferrari);

        SportsCar ford = new SportsCar("Ford", "2019", 80000, Equipment.SPORT, "USA", "30.06.2021", "B.N. Pit", 270, 85, 290);
        warehouseStorage.addCar(ford);

        UsedCar bmw = new UsedCar("BMV", "2009", 5400, Equipment.CLASSIC, "Germany", "8.04.2012", "L.V. Schmidt", 60000, "P.V. Ivanov");
        parkingLot.addCar(bmw);

        UsedCar gilly = new UsedCar("Gilly", "2015", 9000, Equipment.BUSINESS, "Japan", "30.08.2018", "S.S. Li", 40000, "B.V. Philipchuk");
        parkingLot.addCar(gilly);

        SpecialMachinery garbageTruck = new SpecialMachinery("Truck", "2020", 90000, Equipment.SPECIAL_EQUIPMENT, "Germany", "20.02.2022", "D.B. Meier", "garbage truck", 3000);
        warehouseStorage.addCar(garbageTruck);

        parkingLot.showStorageCars();
        warehouseStorage.showStorageCars();

    }
}
