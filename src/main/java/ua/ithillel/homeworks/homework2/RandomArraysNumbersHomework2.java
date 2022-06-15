package ua.ithillel.homeworks.homework2;

import java.util.Arrays;
import java.util.Random;

public class RandomArraysNumbersHomework2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 10;
        }
        System.out.println(Arrays.toString(array));

        double sum = 0;
        int j = 0;
        while (j < array.length) {
            int i = array[j];
            sum += i;
            j++;
        }
        double average = sum / array.length;
        System.out.println(average);
    }
}
