
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        ArrayList <EastAsiaCountries> list=new ArrayList<EastAsiaCountries>();
        ManageEastAsiaCountries manage = new ManageEastAsiaCountries();
        // loop until users want to exit
        while (true) {
            //displaymenu and ask users select an option
            displayMenu();
            int choice = GetInput.getInt("Enter your choice: ", 1, 5);
            switch (choice) {
                // addinformation for 11 countries in Southeast Asia.
                case 1:
                    manage.addCountryInformation(list);
                    break;
                // displayinformation of country you have just input
                case 2:
                    manage.displayinformation(list);
                    break;
                //searchCountry according to the entered country's name.
                case 3:
                    manage.searchCountry(list);
                    break;
                //Display the information sort name ascending with the country name.
                case 4:
                    manage.sort(list);
                    break;
                //exit 
                case 5:
                    System.exit(0);
            }
        }
    }

    // displayMenu
    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }

}
