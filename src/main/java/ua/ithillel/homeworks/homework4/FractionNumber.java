package ua.ithillel.homeworks.homework4;

public final class FractionNumber {

    private final int numerator;
    private final int denominator;

    public FractionNumber(int numerator, int denominator) {
        if (denominator == 0) {
            try {
                throw new Exception("You can't divide by zero");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public static FractionNumber plus(FractionNumber f1, FractionNumber f2) {
        FractionNumber result = new FractionNumber(f1.numerator * f2.denominator + f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        return result.simplify();
    }

    public static FractionNumber minus(FractionNumber f1, FractionNumber f2) {
        FractionNumber result = new FractionNumber(f1.numerator * f2.denominator - f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        return result.simplify();
    }

    public static FractionNumber multiply(FractionNumber f1, FractionNumber f2) {
        FractionNumber result = new FractionNumber(f1.numerator * f2.numerator, f1.denominator * f2.denominator);
        return result.simplify();
    }

    public static FractionNumber divide(FractionNumber f1, FractionNumber f2) {
        FractionNumber result = new FractionNumber(f1.numerator * f2.denominator, f1.denominator * f2.numerator);
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
        if (denominator != 1)
            return numerator + "/" + denominator;
        else
            return numerator + "";
    }
}
