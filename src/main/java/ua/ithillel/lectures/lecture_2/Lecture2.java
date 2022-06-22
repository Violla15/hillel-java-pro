package ua.ithillel.lectures.lecture_2;

import java.util.Arrays;

public class Lecture2 {
    public static void main(String[] args) {
        int[] myArray = new int[3];
        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;
        System.out.println(Arrays.toString(myArray));


        doWhile();
        drawSquare(7);
        getDayOfWeek(6);
    }

    public static void doWhile() {
        int i = 0;
        do {
            i++;
            System.out.println(" i = " + i);
        } while (i != 10);

        while (i != 0) {
            i--;
            System.out.println(" i = " + i);
        }
    }

    public static String getDayOfWeek(int dayNumber) {
        String day = " ";
        switch (dayNumber) {
            case 1:
                return " Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday ";
            case 5:
                return "Friday";
            case 6:
                return "Saturday ";
            case 7:
                return "Sunday";
            default:
                System.out.println("default");
                break;
        }

        System.out.println(getDayOfWeek(6));
        return day;
    }

    public static void drawSquare(int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(" ");
            for (int j = 0; j < size; j++) {
                System.out.print("# ");
            }
        }
    }
}
