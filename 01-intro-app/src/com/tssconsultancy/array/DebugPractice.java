package com.tssconsultancy.array;

import java.util.ArrayList;
import java.util.List;

public class DebugPractice {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        int sum = calculateSum(numbers);
        System.out.println("Sum: " + sum);

        double average = calculateAverage(numbers);
        System.out.println("Average: " + average);

        String result = findNumber(numbers, 7);
        System.out.println(result);
    }

    private static int calculateSum(List<Integer> numbers) {
        int sum = 0;

        for (Integer num : numbers) {
            sum += num;
        }

        return sum;
    }

    private static double calculateAverage(List<Integer> numbers) {
        int sum = calculateSum(numbers);

        // Intentional bug
        return sum / numbers.size();
    }

    private static String findNumber(List<Integer> numbers, int target) {

        for (int i = 0; i <= numbers.size(); i++) {

            if (numbers.get(i) == target) {
                return "Found at index: " + i;
            }
        }

        return "Not Found";
    }
}
