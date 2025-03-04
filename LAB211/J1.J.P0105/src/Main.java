
import java.text.ParseException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Le Viet
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        ArrayList<Storekeeper> listStorekeepers = new ArrayList<>();
         ArrayList<Product> listProduct = new ArrayList<>();
        ManagerProduct managerProduct = new ManagerProduct();
        InputInformationProduct inputInfor = new InputInformationProduct();
        //loop until user want to exit your program
        while (true) {
            //Step 1: Display menu
            managerProduct.displayMenu();
            //Step 2: Ask user to select an option
            int userChoice = inputInfor.inputChoice(1,7);
            switch (userChoice) {
                //Step 3: Add Storekeeper
                case 1:
                   managerProduct.addStorekeeper(listStorekeepers);
                    break;
                //Step 4:  Add Product
                case 2:
                   managerProduct.addProduct(listStorekeepers,listProduct);
                    break;
                //Step 5: Update Product 
                case 3:
                    managerProduct.updateProduct(listStorekeepers,listProduct);
                    break;
                //Step 6: Search product by Name, Category, Storekeeper, ReceiptDate
                case 4:
                    managerProduct.searchInforProduct(listProduct);
                    break;
                //Step 7:  Sort product by Expiry date, Date of manufacture
                case 5:
                    managerProduct.sortProduct(listProduct);
                    managerProduct.displayAllInfor(listProduct);
                    break;
                //Step 8: Display all information
                case 6:
                    managerProduct.displayAllInfor(listProduct);
                    break;
                //Step 9: Exit program
                case 7:
                    System.exit(0);
            }

        }

    }

}
