package ua.ithillel.homeworks.homework4;

public final class FractionNumber {

    private final int numerator;
    private final int denominator;

    public FractionNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public FractionNumber plus(FractionNumber fractionNumber) {
        FractionNumber result = new FractionNumber((numerator * fractionNumber.getDenominator()) + (fractionNumber.getNumerator() * denominator), denominator * fractionNumber.getDenominator());
        return result.simplify();
    }

    public  FractionNumber minus(FractionNumber fractionNumber) {
        FractionNumber result = new FractionNumber((numerator * fractionNumber.denominator) - (fractionNumber.numerator * denominator), denominator * fractionNumber.denominator);
        return result.simplify();
    }

    public  FractionNumber multiply(FractionNumber fractionNumber) {
        FractionNumber result = new FractionNumber(numerator * fractionNumber.numerator,denominator * fractionNumber.denominator);
        return result.simplify();
    }

    public  FractionNumber divide(FractionNumber fractionNumber) {
        FractionNumber result = new FractionNumber(numerator * fractionNumber.getDenominator(), denominator * fractionNumber.numerator);
        return result.simplify();
    }

    public static int nod(int a, int b) {
        if (a < 0)
            a = -1 * a;
        if (b < 0)
            b = -1 * b;
        int t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public FractionNumber simplify() {
        int nod = nod(numerator, denominator);
        int a = numerator;
        int b = denominator;
        a = numerator / nod;
        b = denominator / nod;
        return new FractionNumber(a, b);
    }

    @Override
    public String toString() {
            return numerator + "/" + denominator;
    }
}
