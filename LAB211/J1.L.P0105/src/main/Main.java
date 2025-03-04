package main;

import entity.Product;
import entity.Storekeeper;
import Manager.ControlProduct;
import Manager.GetDataInput;
import Manager.ProductManagement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        GetDataInput input = new GetDataInput();
        List<Storekeeper> storekeepers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        ProductManagement manager = new ProductManagement(storekeepers, products);
        ControlProduct controlProduct = new ControlProduct(manager);

        boolean isStop = false;
        while (!isStop) {
            //Step1: Display menu 
            displayMenu();
            //Step2: User input an choose
            int choose = input.inputChoose("", 1, 6);
            //Step3: Perform function based on the selected choose.
            switch (choose) {
                //choose1: Add Storekeeper
                case 1: {
                    controlProduct.addStorekeeper();
                    break;
                }
                //choose2: Add product
                case 2: {
                    controlProduct.addProduct();
                    break;
                }
                //choose3: Update product: Find an product by Id
                case 3: {
                    controlProduct.updateProduct();
                    break;
                }
                //choose4: Search product by Name, Category, Storekeeper
                case 4: {
                    controlProduct.searchProduct();
                    break;
                }
                //choose5: Sort product (by Expiry date, Date of manufacture)
                case 5: {
                    controlProduct.sortProduct();
                    break;
                }
                //6. Exit
                case 6: {
                    isStop = true;
                    break;
                }
            }
        }
    }

    public static void displayMenu() {
        System.out.println("========Main menu=======\n"
                + "1.	Add Storekeeper\n"
                + "2.	Add product\n"
                + "3.	Update product\n"
                + "4.	Search product by Name, Category, Storekeeper, ReceiptDate\n"
                + "5.	Sort product by Expiry date, Date of manufacture");
        System.out.print("Your choice: ");
    }
}
