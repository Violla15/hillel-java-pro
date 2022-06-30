package ua.ithillel.homeworks.homework5.car;

public class SpecialEquipment extends Car {

    private String type;
    private int weight;

    public SpecialEquipment(String brand, String yearOfManufacture, int price, Equipment equipment, String countryOfManufacture, String dateOfSale, String nameOfTheBuyer, String type, int weight) {
        super(brand, yearOfManufacture, price, equipment, countryOfManufacture, dateOfSale, nameOfTheBuyer);
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
