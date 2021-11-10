package com.minhho.views;

public class MainMenuInterface {

    public static void displayMenu() {
        System.out.println("WELCOME TO CSD201x_02_VN ASM1 PROJECT");
        System.out.println("Author: Ho Nhat Minh | FX03283");
        System.out.println("//////////////////////////////////////");
        System.out.println();
        System.out.println("PLEASE SELECT YOUR OPTION:");
        System.out.println("1. Input new integer array a to INPUT.TXT");
        System.out.println("2. Output the integer array a from INPUT.TXT");
        System.out.println("3. Sort array by Bubble Sort algorithm. Write output of every sorting step to OUTPUT1.TXT");
        System.out.println("4. Sort array by Selection Sort algorithm. Write output of every sorting step to OUTPUT2.TXT");
        System.out.println("5. Sort array by Insertion Sort algorithm. Write output of every sorting step to OUTPUT3.TXT");
        System.out.println("6. Using the Linear Search method, print to the screen the positions of all elements with a " +
                "value greater than input-value (input-value is a real number entered by the user) " +
                "in the array a in step 2 (unsorted array).");
        System.out.println("7. Using Binary Search method, print to the screen the position of the first element " +
                "whose value is equal" +
                " to input-value (input-value is a real number entered by the user) in array b " +
                "(array b is an array a after it has been sorted using one of the three algorithms in steps 3,4,5).");
        System.out.println("0. Quit the program");

        System.out.println("//////////////////////////////////////");
    }

}
