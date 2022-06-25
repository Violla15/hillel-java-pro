package ua.ithillel.homeworks.homework4;

public class Homework4 {
    public static void main(String[] args) {
        FractionNumber fractionNumber1 = new FractionNumber(2, 4);
        FractionNumber fractionNumber2 = new FractionNumber(1, 4);
        FractionNumber fractionNumber3 = new FractionNumber(3,6);

        FractionNumber plusResult = fractionNumber1.plus(fractionNumber2);
        System.out.println("Plus operation result is : " + plusResult);

        FractionNumber minusResult = fractionNumber1.minus(fractionNumber2);
        System.out.println("Minus operation result is : "+ minusResult);

        FractionNumber multiplyResult = fractionNumber2.multiply(fractionNumber3);
        System.out.println("Multiply operation result is : "+ multiplyResult);

        FractionNumber divideResult = fractionNumber2.divide(fractionNumber1);
        System.out.println("Divide operation result is : " + divideResult);

    }
}