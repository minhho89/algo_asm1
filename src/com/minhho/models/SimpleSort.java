package com.minhho.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleSort {

    private UserIO userIO;
    private int[] resultArray;
    private String fileName;
    private ArrayList<int[]> outputList = new ArrayList<>();

    public SimpleSort(UserIO userIO) {
        this.userIO = userIO;
        copyFromUserArray();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int[] getResultArray() {
        return resultArray;
    }

    private void copyFromUserArray() {
        resultArray = new int[userIO.getIntArray().length];
        for (int i = 0; i <  userIO.getIntArray().length; i++) {
            resultArray[i] =  userIO.getIntArray()[i];
        }
    }

    private int[] copyArray(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }

        int temp;
        temp = resultArray[i];
        resultArray[i] = resultArray[j];
        resultArray[j] = temp;
    }

    public void bubbleSort() {
        System.out.println("Performing Bubble Sort...");
        for (int unsortedIndex = resultArray.length; unsortedIndex > 0; unsortedIndex--) {
            for (int i = 0; i < unsortedIndex - 1; i++) {
                if (resultArray[i] > resultArray[i + 1])
                    swap(i, i+1);
            }
            int[] temp = copyArray(resultArray);
            outputList.add(temp); // add to list to write to file
            printResultArray();
        }
        System.out.println("Array sorted");
        System.out.println();
    }

    public void selectionSort() {
        int min_idx;
        System.out.println("Performing Selection Sort...");
        for (int i = 0; i < resultArray.length - 1; i++) {
            min_idx = i;
            for (int j = i + 1; j < resultArray.length ; j++) {
                if (resultArray[j] < resultArray[min_idx])
                    swap(j, min_idx);
            }
            int[] temp = copyArray(resultArray);
            outputList.add(temp); // add to list to write to file
            printResultArray();
        }

        System.out.println("Array sorted");
        System.out.println();
    }

    public void insertionSort() {
        System.out.println("Performing Insertion Sort...");
        for (int i = 1; i < resultArray.length; i++) {
            int key = resultArray[i];
            int j = i - 1;
            while(j >= 0 && resultArray[j] > key) {
                resultArray[j + 1] = resultArray[j];
                j = j - 1;
            }
            resultArray[j + 1] = key;

            int[] temp = copyArray(resultArray);
            outputList.add(temp); // add to list to write to file
            printResultArray();
        }

        System.out.println("Array sorted");
        System.out.println();
    }

    private void printResultArray() {
        System.out.println(Arrays.toString(resultArray));
    }

    public void writeToFile() {
        System.out.println("Writing result to file...");
        try {
            FileWriter write = new FileWriter(fileName);
            for(int[] a : outputList) {
                write.write(Arrays.toString(a) + "\n");
            }
            System.out.println("Writing to file completed.");
            System.out.println();
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Writing to file failed.");
        }

    }
}
