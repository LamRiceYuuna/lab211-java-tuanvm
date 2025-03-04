/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author win
 */
public class TPBank {

    public static void main(String[] args) {
        Management manager = new Management();
        while (true) {
            //display menu
            displayMenu();
            //Get option
            int option = GetInput.getOption("Please choice one option:", "option[1-3]", 1, 3);
            
            ResourceBundle bundle = ResourceBundle.getBundle("tpbank.language_en_US");
            Locale locale;
            switch (option) {
                //option = 1, Login with vietnamese
                case 1:
                    locale = new Locale("vi", "VN");
                    manager.login(locale);
                    break;
                //option = 2, Login with english
                case 2:
                    locale = new Locale("en", "US");
                    manager.login(locale);
                    break;
                //option = 3, exit
                case 3:
                    System.exit(0);
                    break;
            }

        }
    }

    private static void displayMenu() {
        System.out.println("-------Login Program-------\n"
                + "1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
    }
}
