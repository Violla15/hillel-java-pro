package ua.ithillel.homeworks.homework5.car;

public class UsedCar extends Car {
    private int mileage;
    private String fullNameOfTheOwner;

    public UsedCar(String brand, String yearOfManufacture, int price, Equipment equipment, String countryOfManufacture, String dateOfSale, String nameOfTheBuyer, int mileage, String fullNameOfTheOwner) {
        super(brand, yearOfManufacture, price, equipment, countryOfManufacture, dateOfSale, nameOfTheBuyer);
        this.mileage = mileage;
        this.fullNameOfTheOwner = fullNameOfTheOwner;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFullNameOfTheOwner() {
        return fullNameOfTheOwner;
    }

    public void setFullNameOfTheOwner(String fullNameOfTheOwner) {
        this.fullNameOfTheOwner = fullNameOfTheOwner;
    }
}
