package ua.ithillel.homeworks.homework4;

public class Homework4 {
    public static void main(String[] args) {
        FractionNumber fractionNumber1 = new FractionNumber(2, 4);
        FractionNumber fractionNumber2 = new FractionNumber(1, 4);
        FractionNumber fractionNumber3 = new FractionNumber(3,6);

        System.out.println(FractionNumber.plus(fractionNumber1,fractionNumber2));
        System.out.println(FractionNumber.minus(fractionNumber2,fractionNumber1));
        System.out.println(FractionNumber.multiply(fractionNumber3,fractionNumber1));
        System.out.println(FractionNumber.divide(fractionNumber3,fractionNumber2));
        System.out.println(FractionNumber.plus(fractionNumber3,fractionNumber1));
        System.out.println(FractionNumber.minus(fractionNumber1,fractionNumber2));
    }
}