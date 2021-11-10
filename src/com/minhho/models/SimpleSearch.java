package com.minhho.models;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleSearch {

    private UserIO userIO;

    public SimpleSearch(UserIO userIO) {
        this.userIO = userIO;
    }

    public int inputSearchValue() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Input your value to search: ");

            String answer =  sc.next();
            if (isNumeric(answer)) {
                return Integer.parseInt(answer);
            }
            System.out.println("Invalid input. Please try again.");
        }

    }

    private boolean isNumeric(String input) {
        if (input == null || input.equals("")) {
            return false;
        }

        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public void linearSearch(int value) {
        boolean flag = false;
        System.out.println("Our array: " + Arrays.toString(userIO.getIntArray()));
        System.out.println("Index of elements with a value greater than " + value + ":");

        for (int i = 0; i < userIO.getIntArray().length; i++) {
            if (value < userIO.getIntArray()[i]) {
                flag = true;
                System.out.print(i + " ");
            }
        }

        if(flag == false) {
            System.out.println("No elements with a value greater than " + value + " found.");
        }
        System.out.println();
    }

    public void binarySearch(int value) {
        SimpleSort simpleSort = new SimpleSort(userIO);
        simpleSort.bubbleSort();
        int[] sortedArray = simpleSort.getResultArray();
        System.out.println("Array has been sort. Sorted Array: " + Arrays.toString(sortedArray));

        // Start Binary search algorithm
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) /2);

            if (sortedArray[mid] == value ) {
                System.out.println("Your value position is " + mid);
                return;
            } else if (sortedArray[mid] < value) { // right partition
                low = mid + 1;
            } else if (sortedArray[mid] > value) {
                high = mid - 1;
            }

        }
        System.out.println("No position found.");
    }
}
