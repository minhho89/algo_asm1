package com.minhho.controllers;

import com.minhho.models.SimpleSearch;
import com.minhho.models.SimpleSort;
import com.minhho.models.UserIO;
import com.minhho.utils.AlgoUtils;

import java.util.Scanner;

public class MainController {

    private static UserIO userIO = new UserIO(AlgoUtils.FILE_NAME_INPUT);

    public MainController() {
    }

    public static void userChoiceInput() {
        Scanner sc = new Scanner(System.in);
        userIO.setScanner(sc);
        String choice;


        System.out.print("Please input your choice (0-7): ");
        choice = sc.next();

        while (!choice.matches("^[0-7]")) {
            System.out.print("Please input a valid value. Please try again (0-7): ");
            choice = sc.next();
        }

        switch (choice) {
            case "1":
                userIO.writeToFile();
                break;
            case "2":
                userIO.readFromFile();
                break;
            case "3":
                SimpleSort simpleSort = new SimpleSort(userIO);
                simpleSort.bubbleSort();

                //write to file
                simpleSort.setFileName("OUTPUT1.TXT");
                simpleSort.writeToFile();
                break;
            case "4":
                SimpleSort simpleSort2 = new SimpleSort(userIO);
                simpleSort2.selectionSort();

                //write to file
                simpleSort2.setFileName("OUTPUT2.TXT");
                simpleSort2.writeToFile();
                break;
            case "5":
                SimpleSort simpleSort3 = new SimpleSort(userIO);
                simpleSort3.insertionSort();

                //write to file
                simpleSort3.setFileName("OUTPUT3.TXT");
                simpleSort3.writeToFile();
                break;
            case "6":
                SimpleSearch simpleSearch1 = new SimpleSearch(userIO);
                simpleSearch1.linearSearch(simpleSearch1.inputSearchValue());
                simpleSearch1.writeToFile("OUTPUT4.TXT");
                break;
            case "7":
                SimpleSearch simpleSearch2 = new SimpleSearch(userIO);
                simpleSearch2.binarySearch(simpleSearch2.inputSearchValue());
                simpleSearch2.writeToFile("OUTPUT5.TXT");
                break;
            default:
                // case 0
                //quit
                sc.close();
                System.out.println("Closing app...");
                System.exit(0);
        }

    }

}
