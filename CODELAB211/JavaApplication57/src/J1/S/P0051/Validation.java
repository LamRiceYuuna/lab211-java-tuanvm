/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0051;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);

    int checkInputInteger(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.println("Please input again: ");
            }
        }
    }

    double checkInputDouble() {
        while (true) {
            try {
                double input = Double.parseDouble(sc.nextLine().trim());
                if(input <= 0) {
                    throw new NumberFormatException();
                }
                return input;

            } catch (NumberFormatException e) {
                System.out.println("Please input form double number  ");
                System.out.println("Please input again: ");
            }
        }
    }

    String checkInputOperator() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Operator can't empty");
            } else if (input.equals("+") || input.equals("-")
                    || input.equals("*") || input.equals("/")
                    || input.equals("^") || input.equals("=")) {
                return input;
            } else {
                System.out.println("Please input (+, -, *, /, ^)");
            }
            System.out.println("Please input again: ");
        }
    }
}
