/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author DELL
 */
public class GetInput {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getOption(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.print(msg);
                String str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("IOException");
            }
            System.out.println(err);
        }
    }

    public static String getPassword(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                String str = in.readLine();
                // check valid 1 word and 1 number
                if (str.matches("^[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*$") && str.matches("^[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*$")) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("IOException");
            }
            System.out.println(err);
        }

    }
}
