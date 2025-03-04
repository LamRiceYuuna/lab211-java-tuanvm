
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ManagerProduct {

    InputInformationProduct inputInfor = new InputInformationProduct();

    public ManagerProduct() {

    }
    
    

    //Method used to display menu 
    void displayMenu() {
        System.out.println("===========Products management system=========");
        System.out.println("Main menu:");
        System.out.println("1. Add storekeeper");
        System.out.println("2. Add product");
        System.out.println("3. Update product");
        System.out.println("4. Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("5. Sort product by Expiry date, Date of manufacture");
        System.out.println("6. Display all information");
        System.out.println("7. Exit");
        System.out.println("====================================================="
                + "=========================================");
    }

    //Method used to add storekeeper in the list
    void addStorekeeper(ArrayList<Storekeeper> listStorekeepers) {
        System.out.println("---------Add Storekeeper----------");

        String nameStorekeeper = "";
        //loop until user input all name of storekeeper

        while (true) {
            nameStorekeeper = inputInfor.inputInforByMessage("Enter StoreKeeper Name: ",
                    "^[a-zA-Z0-9 ]+$");
            if (isExist(listStorekeepers, nameStorekeeper)) {

                System.out.println("Storekeeper is already in use "
                        + " please enter another Storekeeper!");
            } else {
                break;
            }

        }

        listStorekeepers.add(new Storekeeper(nameStorekeeper, id));

        System.out.println("Add successfull!!!");
    }

    private int indexOfstorekeeper(ArrayList<Storekeeper> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            Storekeeper storekeeper = list.get(i);
            if (storekeeper.getStorekeeper().equalsIgnoreCase(name)) {//If there is any id that is equal to the id I passed, return the position of that id
                return i;
            }
        }
        return -1;
    }

    //check storekeeper
    public boolean isExist(ArrayList<Storekeeper> list, String name) {
        int index = indexOfstorekeeper(list, name);
        if (index != -1) {
            return true;
        }
        return false;
    }

    //Method used to add Products in the list
    public void addProduct(ArrayList<Storekeeper> listStorekeepers, ArrayList<Product> listProduct) {
        // check if list storekeeper is empty
        if (listStorekeepers.isEmpty()) {
            System.out.println("List Storekeepers is empty! "
                    + "Please input list name of storekeeper first");
            return;
        }
        int numberProduct = inputInfor.inputNumber("Enter number of products:");
        //loop until all products 
        for (int i = 0; i < numberProduct; i++) {
            String id = inputInfor.inputIDOfProduct(listProduct);
            //condion of regex check name: alphabetics, numbers and space
            String name = inputInfor.inputInforByMessage("Enter name of products: ",
                    "^[a-zA-Z0-9 ]+$");
            //condion of regex check category: alphabetics, numbers and space
            String category = inputInfor.inputInforByMessage("Enter category: ",
                    "^[a-zA-Z0-9 ]+$");
            double price = inputInfor.inputPrice();
            String storekeeper = inputInfor.inputNameOfStorekeeper(listStorekeepers);
            //condion of regex check location: alphabetics, numbers and space
            String location = inputInfor.inputInforByMessage("Enter location: ",
                    "^[a-zA-Z0-9 ]+$");
            Date expiryDate = inputInfor.inputDate("Enter Expiry Date (Format:dd/MM/yyyy): ");
            Date dateOfManufacture = inputInfor.inputDateOfManufacture(expiryDate);
            Date receiptDate = inputInfor.inputReceiptDate(expiryDate, dateOfManufacture);
            listProduct.add(new Product(id, name, category, price, storekeeper,
                    location, expiryDate, dateOfManufacture, receiptDate));
            System.out.println("Add successful!");
        }

    }

    //Method used to update product
    public void updateProduct(ArrayList<Storekeeper> listStorekeepers, ArrayList<Product> listProduct) {
        //check if product is empty
        if (listProduct.isEmpty()) {
            System.out.println("List product is empty!");
            return;
        }
        System.out.println("------- Update Product-----------");
        String idOfProduct = inputInfor.inputIDExistInList(listProduct);
        Product product = getInforProductByID(listProduct, idOfProduct);
        String idToUpdate = "";
        //loop until user input correct id of product to updatte
        while (true) {
            //Regex to check ID:
            //Condition: alphabetic, number and space
            idToUpdate = inputInfor.inputInforByMessage("Enter ID to update: ", "^[a-zA-Z0-9 ]+$");
            //check user input duplicate code of product
            if (isDuplicateID(listProduct, idToUpdate) == true && !idToUpdate.equalsIgnoreCase(idOfProduct)) {
                System.out.println("Duplicate ID of Product!");
            } else {
                break;
            }
        }
        //condion of regex check name: alphabetics, numbers and space
        String name = inputInfor.inputInforByMessage("Enter name of products: ",
                "^[a-zA-Z0-9 ]+$");
        //condion of regex check category: alphabetics, numbers and space
        String category = inputInfor.inputInforByMessage("Enter category: ",
                "^[a-zA-Z0-9 ]+$");
        double price = inputInfor.inputPrice();
        String storekeeper = inputInfor.inputNameOfStorekeeper(listStorekeepers);
        //condion of regex check location: alphabetics, numbers and space
        String location = inputInfor.inputInforByMessage("Enter location: ",
                "^[a-zA-Z0-9 ]+$");
        Date expiryDate = inputInfor.inputDate("Enter Expiry Date (Format:dd/MM/yyyy): ");
        Date dateOfManufacture = inputInfor.inputDateOfManufacture(expiryDate);
        Date receiptDate = inputInfor.inputReceiptDate(expiryDate, dateOfManufacture);
        //check if user not change information of product
        if (isNoChangeInfoProduct(product, idToUpdate, name, category, price,
                storekeeper, location, expiryDate, dateOfManufacture, receiptDate)) {
            System.out.println("Information of Product is not change!!");
        } else {
            product.setID(idToUpdate);
            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setStorekeeper(storekeeper);
            product.setLocation(location);
            product.setExpiryDate(expiryDate);
            product.setDateOfManufacture(dateOfManufacture);
            product.setReceiptDate(receiptDate);
            System.out.println("Update successfull!!");
        }
    }

    //Method used to search information by Name, Category,Storekeeper or ReciptDate
    public void searchInforProduct(ArrayList<Product> listProduct) {
        //check list product is empty or not
        if (listProduct.isEmpty()) {
            System.out.println("List Product empty!!!");
            return;
        }
        //loop until user want to exist method search product
        while (true) {
            System.out.println("--------Menu-------------------------");
            System.out.println("1. Search product by Name");
            System.out.println("2. Search product by Category");
            System.out.println("3. Search product by Storekeeper");
            System.out.println("4. Search product by ReceiptDate");
            System.out.println("--------------------------------------");
            int userChoice = inputInfor.inputChoice(1, 4);
            //update information with each appropriate case 
            switch (userChoice) {
                //option 1: Search product by Name
                case 1:
                    //condion of regex check name: alphabetics, numbers and space
                    String nameProduct = inputInfor.inputInforByMessage("Enter name you want to search: ",
                            "^[a-zA-Z0-9 ]+$");
                    searchByName(listProduct, nameProduct);
                    String choice1 = inputInfor.inputChoiceYN();
                    //check if user want to exist this method
                    if ("N".equalsIgnoreCase(choice1)) {
                        return;
                    }
                    break;
                //option 2: Search product by Category
                case 2:
                    //condion of regex check name: alphabetics, numbers and space
                    String category = inputInfor.inputInforByMessage("Enter category you want to search: ",
                            "^[a-zA-Z0-9 ]+$");
                    searchByCategory(listProduct, category);
                    String choice2 = inputInfor.inputChoiceYN();
                    //check if user want to exist this method
                    if ("N".equalsIgnoreCase(choice2)) {
                        return;
                    }
                    break;
                //option 3: Search product by Storekeeper
                case 3:
                    //condion of regex check name: alphabetics, numbers and space
                    String storekeeper = inputInfor.inputInforByMessage("Enter storekeeper you want to search: ",
                            "^[a-zA-Z0-9 ]+$");
                    searchByStorekeeper(listProduct, storekeeper);
                    String choice3 = inputInfor.inputChoiceYN();
                    //check if user want to exist this method
                    if ("N".equalsIgnoreCase(choice3)) {
                        return;
                    }
                    break;
                //option 4: Search product by ReceiptDate
                case 4:
                    Date receiptDate = inputInfor.inputDate("Input Receipt Date you want to search:");
                    searchByReceiptDate(listProduct, receiptDate);
                    String choice4 = inputInfor.inputChoiceYN();
                    //check if user want to exist this method
                    if ("N".equalsIgnoreCase(choice4)) {
                        return;
                    }
                    break;
            }
        }
    }

    //method used to search information of product by Name
    private void searchByName(ArrayList<Product> listProduct, String nameProduct) {
        boolean check = false;
        //loop to the end of list product
        for (Product product : listProduct) {
            //check if found the name in the list
            if (product.getName().contains(nameProduct)) {
                if (check == false) {
                    System.out.printf("%1s %20s %20s %20s %20s %20s %30s %40s %20s\n", "ID",
                            "Name", "Category", "Price", "Storekeeper", "Location", "Expiry Date",
                            "Date Of Manufacture", "Receipt Date");
                }
                display(product);
                check = true;
            }
        }
        //check if the name is not found in the list
        if (check == false) {
            System.out.println("Not found the name you want to search!");
        }
    }

    //method used to search information of product by Category
    private void searchByCategory(ArrayList<Product> listProduct, String category) {
        boolean check = false;
        //loop to the end of list product
        for (Product product : listProduct) {
            //check if found the category in the list
            if (product.getCategory().contains(category)) {
                if (check == false) {
                    System.out.printf("%1s %20s %20s %20s %20s %20s %30s %40s %20s\n", "ID",
                            "Name", "Category", "Price", "Storekeeper", "Location", "Expiry Date",
                            "Date Of Manufacture", "Receipt Date");
                }
                display(product);
                check = true;
            }
        }
        //check if the category is not found in the list
        if (check == false) {
            System.out.println("Not found the category you want to search!");
        }
    }

    //method used to search information of product by Storekeeper
    private void searchByStorekeeper(ArrayList<Product> listProduct, String storekeeper) {
        boolean check = false;
        //loop to the end of list product
        for (Product product : listProduct) {
            //check if found the category in the list
            if (product.getStorekeeper().contains(storekeeper)) {
                if (check == false) {
                    System.out.printf("%1s %20s %20s %20s %20s %20s %30s %40s %20s\n", "ID",
                            "Name", "Category", "Price", "Storekeeper", "Location", "Expiry Date",
                            "Date Of Manufacture", "Receipt Date");
                }
                display(product);
                check = true;
            }
        }
        //check if the storekeeper is not found in the list
        if (check == false) {
            System.out.println("Not found the category you want to search!");
        }
    }

    //Method used to search information of product receipt date
    private void searchByReceiptDate(ArrayList<Product> listProduct, Date receiptDate) {
        boolean check = false;
        //loop to the end of list product
        for (Product product : listProduct) {
            //check if found the receipt Date in the list
            if (product.getReceiptDate().compareTo(receiptDate) == 0) {
                if (check == false) {
                    System.out.printf("%1s %20s %20s %20s %20s %20s %30s %40s %20s\n", "ID",
                            "Name", "Category", "Price", "Storekeeper", "Location", "Expiry Date",
                            "Date Of Manufacture", "Receipt Date");
                }
                display(product);
                check = true;
            }
        }
        //check if the receipt Date is not found in the list
        if (check == false) {
            System.out.println("Not found the receipt date you want to search!");
        }

    }

    //Method used to sort product by  Expiry date, , date of manufacture
    public void sortProduct(ArrayList<Product> listProduct) {
        //check if list product is empty    
        if (listProduct.isEmpty()) {
            System.out.println("List product is empty!");
            return;
        }
        Product product1 = null, product2 = null;
        Date expiryDate1, expiryDate2;
        Date dateOfManufacture1, dateOfManufacture2;
        //loop until end of the list product
        for (int i = 0; i <= listProduct.size() - 1; i++) {
            product1 = listProduct.get(i);
            expiryDate1 = product1.getExpiryDate();
            dateOfManufacture1 = product1.getDateOfManufacture();
            for (int j = i + 1; j < listProduct.size(); j++) {
                product2 = listProduct.get(j);
                expiryDate2 = product2.getExpiryDate();
                dateOfManufacture2 = product2.getDateOfManufacture();
                // check if expirydate1 is grate than expiry date 2
                if (expiryDate1.compareTo(expiryDate2) < 0) {
                    Collections.swap(listProduct, i, j);

                }//check if expirydate1 is equal to expiry date 2
                else if (expiryDate1.compareTo(expiryDate2) == 0) {
                    // check if dateOfManufacture1 is grate than dateOfManufacture2
                    if (dateOfManufacture1.compareTo(dateOfManufacture2) > 0) {
                        Collections.swap(listProduct, i, j);
                    }
                }

            }
        }
    }

    //method used to display all infor mation of product
    void displayAllInfor(ArrayList<Product> listProduct) {
        //check if list product is empty
        if (listProduct.isEmpty()) {
            System.out.println("List product is empty!");
            return;
        }
        System.out.printf("%1s %20s %20s %20s %20s %20s %30s %40s %20s\n", "ID",
                "Name", "Category", "Price", "Storekeeper", "Location", "Expiry Date",
                "Date Of Manufacture", "Receipt Date");
        for (Product product : listProduct) {
            display(product);
        }
    }

    // Method used to display all infomation of product    
    private void display(Product product) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%1s %20s %20s %20s %20s %20s %30s %40s %20s\n",
                product.getID(), product.getName(), product.getCategory(),
                product.getPrice(), product.getStorekeeper(), product.getLocation(),
                dateFormat.format(product.getExpiryDate()),
                dateFormat.format(product.getDateOfManufacture()),
                dateFormat.format(product.getReceiptDate()));
        System.out.println();
    }

    // Method used to check user input duplicate ID of Products
    public boolean isDuplicateID(ArrayList<Product> listProduct, String id) {
        //loop until all Products in the list Products are exhausted
        for (Product product : listProduct) {
            //check if find ID of Products in the list
            if (product.getID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    //Method used to get information of product by ID
    public Product getInforProductByID(ArrayList<Product> listProduct, String id) {
        //loop until find product by ID
        for (Product product : listProduct) {
            if (product.getID().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

    //Method used to check if user no change information when update infomation
    public boolean isNoChangeInfoProduct(Product infoProduct, String id, String name,
            String category, double price, String storekeeper, String location, Date expiryDate,
            Date dateOfManufacture, Date receiptDate) {
        return infoProduct.getID().equalsIgnoreCase(id)
                && infoProduct.getName().equalsIgnoreCase(name)
                && infoProduct.getCategory().equalsIgnoreCase(category)
                && infoProduct.getPrice() == price
                && infoProduct.getStorekeeper().equalsIgnoreCase(storekeeper)
                && infoProduct.getLocation().equalsIgnoreCase(location)
                && infoProduct.getExpiryDate().equals(expiryDate)
                && infoProduct.getDateOfManufacture().equals(dateOfManufacture)
                && infoProduct.getReceiptDate().equals(receiptDate);

    }
    
    
    
}
