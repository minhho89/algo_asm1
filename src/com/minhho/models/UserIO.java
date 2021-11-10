package com.minhho.models;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UserIO {

    private String fileName;
    private int[] intArray;
    private Scanner scanner;

    public UserIO(String fileName) {
        this.fileName = fileName;

        if (new File(fileName).exists()) {
            readFromFile(); // set intArray
        }

    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public UserIO(String fileName, int[] intArray) {
        this.fileName = fileName;
        this.intArray = intArray;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void writeToFile()  {
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(fileName);

            System.out.print("Input array length: ");
            int length = scanner.nextInt();

            int[] intArray = new int[length];

            for (int i = 0; i < length; i++) {
                System.out.print("Input element at index " + i + ": ");
                intArray[i] = scanner.nextInt();
            }

            System.out.println("Writing to file...");

            printWriter.println(length);
            printWriter.println(Arrays.toString(intArray));

            System.out.println("File saved.");
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }

    public void readFromFile() {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {

            System.out.println("Reading data from " + fileName + "...");

            reader = new FileReader(fileName);
            bufferedReader = new BufferedReader(reader);

            String regexInt = "\\d+"; // is numeric

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                if (line.matches(regexInt)) { // is array length
                    intArray = new int[Integer.parseInt(line)];
                } else {
                    extractInt(line);
                }
            }

            reader.close();
            bufferedReader.close();

            System.out.println("End reading");
            System.out.println();

        } catch (IOException e) {
            System.out.println("No array has been input. Please input array first");
        }
    }

    /**
     * Extract int values from text file and store to intArray
     * @param line intArray in String type
     */
    private void extractInt(String line) {
        String newString = line.replaceAll("[\\[\\]]", "");

        String[] split = newString.split(",");
        intArray = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            intArray[i] = Integer.parseInt(split[i].trim());
        }
    }
}
