package ua.ithillel.homeworks.homework2;

import java.util.Arrays;

public class SumOfArrayNumbersHomework2 {
    public static void main(String[] args) {
        int[] array = {5, 7, 10, 17};
        int x = 17;
        System.out.println(Arrays.toString(showSumIndexNumbers(array, x)));

        int[] array2 = {6, 6, 12, 16};
        int y = 28;
        System.out.println(Arrays.toString(showSumIndexNumbers(array2, y)));
    }

    public static int[] showSumIndexNumbers(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}



