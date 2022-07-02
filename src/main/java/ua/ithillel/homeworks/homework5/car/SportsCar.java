package ua.ithillel.homeworks.homework5.car;

public class SportsCar extends Car {

    private int maxSpeed;
    private int engineSize;
    private int power;

    public SportsCar(String brand, String yearOfManufacture, int price, Equipment equipment, String countryOfManufacture, String dateOfSale, String nameOfTheBuyer, int maxSpeed, int engineSize, int power) {
        super(brand, yearOfManufacture, price, equipment, countryOfManufacture, dateOfSale, nameOfTheBuyer);
        this.maxSpeed = maxSpeed;
        this.engineSize = engineSize;
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
