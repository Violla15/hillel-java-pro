package ua.ithillel.homeworks.homework5.car;

public class Car {
    private String brand;
    private String yearOfManufacture;
    private int price;
    private Equipment equipment;
    private String countryOfManufacture;
    private String dateOfSale;
    private String nameOfTheBuyer;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public Car(String brand, String yearOfManufacture, int price, Equipment equipment, String countryOfManufacture, String dateOfSale, String nameOfTheBuyer) {
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.equipment = equipment;
        this.countryOfManufacture = countryOfManufacture;
        this.dateOfSale = dateOfSale;
        this.nameOfTheBuyer = nameOfTheBuyer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }

    public String getCountryOfManufacture() {
        return countryOfManufacture;
    }

    public void setCountryOfManufacture(String countryOfManufacture) {
        this.countryOfManufacture = countryOfManufacture;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public String getNameOfTheBuyer() {
        return nameOfTheBuyer;
    }

    public void setNameOfTheBuyer(String nameOfTheBuyer) {
        this.nameOfTheBuyer = nameOfTheBuyer;
    }

    @Override
    public String toString() {
        return (ANSI_BLUE +  brand + ANSI_PURPLE + " (" + equipment + ") " + " Buyer : " + nameOfTheBuyer + ANSI_RESET);
    }
}
