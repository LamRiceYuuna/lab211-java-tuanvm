package Manager;

import entity.Product;
import entity.Storekeeper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ControlProduct {
    GetDataInput input = new GetDataInput();
    ProductManagement productManagement;

    public ControlProduct(ProductManagement productManagement) {
        this.productManagement = productManagement;
    }

    public void addStorekeeper() {
        
        while (true) {
            Storekeeper storekeeper = inputStorekeeper();
            productManagement.addStorekeeper(storekeeper);

            System.out.println("Add storekeeper successful.");
            System.out.println("");
            System.out.println("LIST STOREKEEPERS");
            displayStorekeepers();
            System.out.println("");
            if (!input.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + "press \"N\" if you want to end the action.")) {
                break;
            } else {
                System.out.println("");
                continue;
            }
        }
        System.out.println("");
        System.out.println("Add all storekeeper successful.");
        System.out.println("");
    }

    public Storekeeper inputStorekeeper() {

        int id;
        //check empty product
        if (productManagement.getStorekeepers().isEmpty()) {
            id = 1;
        } 
        //get last id to increase 1
        else {
            id = productManagement.getLastIDStorekeeper() + 1;
        }
        String name = "";
        while (true) {
            name = input.inputStorekeeperName();
            //check duplicate storekeeper name
            if (productManagement.checkDuplicatedStorekeeper(name)) {
                System.out.println("Storekeeper is already in use "
                        + " please enter another Storekeeper!");
                continue;
            } else {
                break;
            }
        }
        Storekeeper s = new Storekeeper(id, name);
        return s;
    }

    public void displayStorekeepers() {
        //Traverse from first element to last element of list storekeeper
        for (Storekeeper s : productManagement.getStorekeepers()) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    public void addProduct() {
        //check empty
        if (productManagement.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        while (true) {
            int id;
            while (true) {
                id = input.inputID();
                //check duplicate id
                if (productManagement.checkDuplicateID(id)) {
                    System.out.println("ID is already in use "
                            + " please enter another ID!");
                    continue;
                } else {
                    break;
                }
            }
            // a-z: lower letter range from a to z
            // A-Z: upper letter range from A to Z
            // 0-9: range number from 0 to 9
            // +: exist as least one or more 
            String name = input.inputString("Product name:", "[a-zA-z0-9 ]+");
            String location = input.inputString("Location:", "[a-zA-z0-9 ]+");
            double price = input.inputPrice();
            Date expiryDate = input.inputExpDate();
            Date dateOfManufacture = input.inputManufactureDate(expiryDate);
            String category = input.inputString("Category: ", "[a-zA-z ]+");
            
            System.out.println("Choose storekeeper [1-" + productManagement.getLastIDStorekeeper() + "]");
            displayStorekeepers();
            System.out.print("Your choice: ");
            int storekeeper = input.inputChoose("", 1, productManagement.getLastIDStorekeeper());
            Storekeeper s = new Storekeeper(productManagement.getStorekeeperByID(storekeeper).getId(), 
                    productManagement.getStorekeeperByID(storekeeper).getName());
            
            Date receiptDate = input.inputReceiptDate(dateOfManufacture, expiryDate);
            Product product = new Product(id, name, location, price, expiryDate, 
                    dateOfManufacture, category, s, receiptDate);
            productManagement.addProduct(product);
            System.out.println("Add product successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll();
            System.out.println("");
            if (!input.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Add all product successful.");
        System.out.println("");
    }

    private void displayAll() {
        System.out.printf("%5s %20s %20s %20s %20s %30s %20s %30s %30s\n", "ID", "Name",
                "Location", "Price", "Expiry date", "Date of manufacture",
                "Category", "Storekeeper", "Receipt date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ////Traverse from first element to last element of list product
        for (Product p : productManagement.getProducts()) {
            System.out.printf("%5s %20s %20s %20s %20s %30s %20s %30s %30s\n",
                    p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                    sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                    p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
        }
    }

    public void updateProduct() {
        //check empty storekeeper
        if (productManagement.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        //check empty product
        if (productManagement.getProducts().isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        Product product = null;
        while (true) {
            int id = input.inputID();
            //check id exist
            if (productManagement.getProductByID(id) == null) {
                System.out.print("ID not found, enter again: ");
                continue;
            }
            //when id is exist
            else {
                product = new Product(productManagement.getProductByID(id).getId(),
                        productManagement.getProductByID(id).getName(), 
                        productManagement.getProductByID(id).getLocation(),
                        productManagement.getProductByID(id).getPrice(), 
                        productManagement.getProductByID(id).getExpiryDate(),
                        productManagement.getProductByID(id).getDateOfManufacture(), 
                        productManagement.getProductByID(id).getCategory(),
                        productManagement.getProductByID(id).getStorekeeper(), 
                        productManagement.getProductByID(id).getReceiptDate());
                System.out.println("Update new information!");
                int newID = 0;
                while (true) {
                    newID = input.inputID();
                    //check duplicate id
                    if (productManagement.checkDuplicateID(newID)==true && newID!=id) {
                        System.out.println("ID is already in use "
                                + " please enter another ID! ");
                        
                    } else {
                        
                        break;
                    }
                }
                product.setId(newID);
                

                String name = input.inputString("New Product name:","[a-zA-z0-9 ]+");
                product.setName(name);

                String location = input.inputString("New Location:", "[a-zA-z0-9 ]+");
                product.setLocation(location);

                double price = input.inputPrice();
                product.setPrice(price);

                Date expiryDate = input.inputExpDate();
                product.setExpiryDate(expiryDate);

                Date dateOfManufacture = input.inputManufactureDate(product.getExpiryDate());
                product.setDateOfManufacture(dateOfManufacture);

                String category = input.inputString("New Category:","[a-zA-z ]+");
                product.setCategory(category);

                System.out.println("Choose new storekeeper [1-" + productManagement.getLastIDStorekeeper() + "]");
                displayStorekeepers();
                System.out.print("Your choice: ");
                int storekeeper = input.inputChoose("", 1, productManagement.getLastIDStorekeeper());
                Storekeeper newStorekeeper = new Storekeeper(productManagement.getStorekeeperByID(storekeeper).getId(),
                        productManagement.getStorekeeperByID(storekeeper).getName());
                
                product.setStorekeeper(newStorekeeper);

                Date receiptDate = input.inputReceiptDate(product.getDateOfManufacture(), product.getExpiryDate());
                product.setReceiptDate(receiptDate);

                productManagement.updateProduct(product, id);
            }
            System.out.println("Update product successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll();
            System.out.println("");
            if (!input.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Update all products successful.");
        System.out.println("");
    }

    public void searchProduct() {
        //check empty storekeepers
        if (productManagement.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        //check empty products
        if (productManagement.getProducts().isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        while (true) {
            int choose = input.inputChoose("Choose information to search Product"
                    + " \n1.Name\n"+"2.Category\n"+"3.Storekeeper\n"+"4.ReceiptDate\n"+"Your Choice: ", 1, 4);
            String chooseStr = "";
            switch (choose) {
                case 1: {
                    chooseStr = "Name";
                    break;
                }
                case 2: {
                    chooseStr = "Category";
                    break;
                }
                case 3: {
                    chooseStr = "Storekeeper";
                    break;
                }
                case 4: {
                    chooseStr = "ReceiptDate";
                    break;
                }
            }
            //^: begin string
            // a-z: lower letter range from a to z
            // A-Z: upper letter range from A to Z
            // 0-9: range number from 0 to 9
            // /: characters /
            //*: zero or more occurrences
            //$: end of string
            String searchValue = input.inputString("Enter data to search: ", "^[a-zA-Z0-9/ ]*$");
            List<Product> searched = productManagement.searchProductBySth(searchValue, choose);
            //check result of search
            if (searched.isEmpty()) {
                System.out.println("There are no " + chooseStr + " product match with "
                        + "\"" + searchValue + "\"");
                return;
            }
            System.out.println("");
            System.out.println("LIST OF PRODUCTS FOUND");
            System.out.printf("%5s %20s %20s %20s %20s %30s %20s %30s %30s\n", "ID", "Name",
                    "Location", "Price", "Expiry date", "Date of manufacture",
                    "Category", "Storekeeper", "Receipt date");
            //Traverse from first element of list to last element of list search
            for (Product p : searched) {
                displayProduct(p);
            }
            System.out.println("");
            if (!input.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
    }

    private void displayProduct(Product p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%5s %20s %20s %20s %20s %30s %20s %30s %30s\n",
                p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
    }

    public void sortProduct() {
        //check empty storekeepers 
        if (productManagement.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        //check empty products
        if (productManagement.getProducts().isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        System.out.println("");
        System.out.println("LIST BEFORE SORT:");
        displayAll();
        System.out.println("");
        productManagement.sortProductList();
        System.out.println("LIST AFTER SORT:");
        displayAll();
        System.out.println("");
    }

}
