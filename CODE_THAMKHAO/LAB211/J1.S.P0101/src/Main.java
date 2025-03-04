
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
        ArrayList <Employee> list=new ArrayList<Employee>();
        ManageEmployee manage = new ManageEmployee();
        while (true) {
            // Step 1: displaymenu
            displayMenu();
            // Step2: getchoice of menu
            int getchoice = GetInput.getInt("Enter choice: ", 1, 6,null);

            switch (getchoice) {
                case 1:
                    // addEmployee
                    manage.addEmployee(list);
                    break;
                case 2:
                    // updateEmployee
                    manage.updateEmployee(list);
                    manage.displayEmployee(list);
                    break;
                case 3:
                    // removeEmployee
                    manage.removeEmployee(list);
                    break;
                case 4:
                    // searchEmployee
                    manage.searchEmplyee(list);
                    break;
                case 5:
                    // sortEmployee
                    manage.sortEmployee(list);
                    manage.displayEmployee(list);
                    break;
                case 6:
                    // exit
                    System.exit(0);

            }
        }
    }

    // displaymenu
    private static void displayMenu() {
        System.out.println("=================================================");
        System.out.println("Main menu:");
        System.out.println("1. Add employees\n"
                + "2. Update employees\n"
                + "3. Remove employees\n"
                + "4. Search employees\n"
                + "5. Sort employees by salary\n"
                + "6. Exit\n");
    }
}
