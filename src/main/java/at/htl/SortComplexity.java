package at.htl;

import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfArrays;
        int length;
        float average = 0;

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        numberOfArrays = scanner.nextInt();

        System.out.print("Größe der Arrays: ");
        length = scanner.nextInt();
        System.out.println();

        for (int i = 0; i < numberOfArrays; i++) {
            long time = sortRandomArray(length);

            System.out.printf("Laufzeit zur Sortierung des %d. Arrays: %d ms%n", i + 1, time);

            average = (average * i + time) / (i + 1);
        }

        System.out.printf("%nDurchschnittliche Laufzeit: %.2f ms", average);
    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        int[] array = generateRandomArray(length);
        long time = System.currentTimeMillis();

        sort(array);

        return System.currentTimeMillis() - time;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
        }

        return array;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }

            }
        }
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        int help = array[i];
        array[i] = array[j];
        array[j] = help;
    }
}
