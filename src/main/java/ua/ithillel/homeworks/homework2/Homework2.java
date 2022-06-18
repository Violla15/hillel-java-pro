package ua.ithillel.homeworks.homework2;

import java.util.Arrays;
import java.util.Random;

public class Homework2 {
    public static void main(String[] args) {
        helloWorld();                             // task - 1
        randomNumbers();                          // task - 2

        int[] arr = {2, 7, 11, 15};               // task - 3
        int x = 9;
        System.out.println(Arrays.toString(showSumIndexNumbers(arr, x)));
    }

    public static void helloWorld() {
        int i = 0;
        while (i++ <= 100) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i + " ");
            } else {
                if (i % 3 == 0 && i % 5 != 0)
                    System.out.print("Hello ");
                if (i % 5 == 0 && i % 3 != 0)
                    System.out.print("World ");
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.print("HelloWorld ");
                }
            }
        }
        System.out.println(" ");
    }
    public static void randomNumbers() {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 11;
        }
        System.out.println(Arrays.toString(array));
        double sum = 0;
        for (int i : array) {
            sum += i;
        }
        double average = sum / array.length;
        System.out.println(average);

    }
    public static int[] showSumIndexNumbers(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}