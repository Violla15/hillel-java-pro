package ua.ithillel.lectures.lecture_15.car;

public class Car {

    private String number;
    private int year;

    public Car(String number, int year) {
        this.number = number;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", year=" + year +
                '}';
    }

    public void print(){
        System.out.println("Car with number "+ number);
    }

    public Car() {
        number= "empty";
        year = 1;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
