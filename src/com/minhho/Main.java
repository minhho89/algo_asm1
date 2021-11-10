package com.minhho;

import com.minhho.controllers.MainController;
import com.minhho.views.MainMenuInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isContinue = true;

        while(isContinue) {
            MainMenuInterface.displayMenu();
            MainController.userChoiceInput();

            boolean isIfConitinue = true;
            while(isIfConitinue) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Do you want to continue using this application? Y/N: ");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                    isIfConitinue = false;
                } else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("No")) {
                    isIfConitinue = false;
                    isContinue = false;
                    System.out.println("Closing app...");
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

    }

}


