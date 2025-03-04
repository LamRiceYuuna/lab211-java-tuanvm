
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Le Viet
 */
public class InputInformationProduct {
    private static final Scanner input = new Scanner(System.in);

    public InputInformationProduct() {
    }
        
    public int inputChoice(int min, int max) {
       int yourChoice;
        //loop until user input correct option
        while (true) {
            try {
                System.out.println("Input your choice:");
                String userChoice = input.nextLine().replaceAll("\\s+"," ").trim();
                
                //check if the user input their choice is empty
                if (userChoice.isEmpty()) {
                    System.out.println("Input empty. Please input your option!");
                } else {
                    yourChoice = Integer.parseInt(userChoice);
                    //check if user input out of rang[min,max]
                    if (yourChoice < min || yourChoice > max) {
                        System.out.println("Please input integer number in range" 
                                + '[' + min + ',' + max + ']');
                        continue;
                    }
                    return yourChoice;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input positive integer number in range "
                        + '[' + min + ',' + max + ']');
            }
        }
    }
    // Method used to allow user input information of product by Message
    public  String inputInforByMessage(String message,String regex) {
        //regex to check information of Employee is right format
        Pattern checkInfor = Pattern.compile(regex);
        // loop until user input correct information of employee
        while (true) {
            System.out.println(message);
            String inforEmployee = input.nextLine().replaceAll("\\s+", " ").trim();
            if (inforEmployee.isEmpty()) {
                System.out.println("Please input not empty. Input again!");
                //check if the entered string matches the condition in the regex 
            } else if (checkInfor.matcher(inforEmployee).find()) {
                return inforEmployee;
            } else {
                System.out.println("Invalid.Please input again");
            }
        }
    }
    //Method used to input number with message
    public int inputNumber(String message) {
        int number = 0;
      //loop until user input correct number of storekeeper
      while(true){ 
          System.out.print(message);
          String stringNumber = input.nextLine().replaceAll("\\s+"," ").trim();
          //check if user input empty number
          if(stringNumber.isEmpty()){
            System.out.println("Please input not empty");
          }else{
              try {
                  number = Integer.parseInt(stringNumber);
                //check if user input number of storekeeper <=0
                  if(number <=0){
                    System.out.println("Number must great than 0!");
                  }else{
                      return number;
                  }
              } catch (NumberFormatException e) {
                  System.out.println("Please input integer number!");
              }
          }
      }
    }
    //Method used to input ID of products
    public String inputIDOfProduct(ArrayList<Product> listProduct){
        ManagerProduct manager = new ManagerProduct();
        //regex to check ID of product is right format
        //condition: Alphabetic, number, space
        Pattern checkID = Pattern.compile("^[a-zA-Z0-9]+$");
        //loop until user input correct ID of Products
        while (true) {
            System.out.println("Enter ID of Products: ");
            String id = input.nextLine().replaceAll("\\s+", " ").trim();
            //check if user input a  empty ID
            if (id.isEmpty()) {
                System.out.println("ID is empty.Please input again!!!");
                // check if the entered string matches the condition in the regex 
            } else if (checkID.matcher(id).find()) {

                //Check if the user has entered the same ID or not
                if (manager.isDuplicateID(listProduct,id)== false) {
                    return id;
                } else {
                    System.out.println("Duplicate ID of Products! ");
                }
            } else {
                System.out.println("The ID of Products can not contain"
                        + "special characters,for example:!,#,@...");
                System.out.println("Please input again");
            }
        }
    }
   //The method use to input  name of storekeeper already exists in the list storekeeper
    public String inputNameOfStorekeeper(ArrayList<Storekeeper> listStorekeepers){
        //regex to check name of storekeeper
        //condition: alphabetics, numbers and spaces
        Pattern checkName = Pattern.compile("^[a-zA-Z0-9 ]+$");
        // loop until user input correct name of  storekeeper
        while (true) {
            displayListStorekeeper(listStorekeepers);
            System.out.println("Choose Storekeeper Name: ");
            String storekeeperName = input.nextLine().replaceAll("\\s+", " ").trim();
            if (storekeeperName.isEmpty()) {
                System.out.println("Please input not empty. Input again!");
                //check if the entered string matches the condition in the regex 
            } else if (checkName.matcher(storekeeperName).find()) {
               //check if storekeeper name not exist in the list
                if(isExistStorekeeper(listStorekeepers, storekeeperName)==false){
                 System.out.println("Name of storekeeper must be exist in the list above");
                 continue;
                }
                return storekeeperName;
            } else {
                System.out.println("Invalid.Please input again");
            }
        }  
    }
    //Method used to dislay list storekeeper
    public void displayListStorekeeper(ArrayList<Storekeeper> listStorekeepers){
        System.out.println("=*=*=*=*=LIST STOREKEEPER =*=*=*=*=");
        //loop until display all storekeeper in the list
        for (Storekeeper listStorekeeper : listStorekeepers) {
            System.out.println(listStorekeeper.getStorekeeper());
        }
        System.out.println("=========================================");
    }
    //method used to check storekeeper is  exist or not
    public boolean isExistStorekeeper(ArrayList<Storekeeper> listStorekeepers,String storekeeper){
      //loop until end of list storekeeper
        for (Storekeeper listStorekeeper : listStorekeepers) {
            if(listStorekeeper.getStorekeeper().equalsIgnoreCase(storekeeper)){
                return true;
            }
        }
        return false;
    }
    
     //Method to alow user input price of products
    public  double inputPrice(){ 
        //loop until user input correct price of products
        while(true){
            try {
               System.out.println("Enter Price: ");
               String  stringPrice = input.nextLine().replaceAll("\\s+", " ").trim();
               //check if user input price is empty
               if(stringPrice.isEmpty()){
                   System.out.println("Total Area must not empty!");
               }else{
                 float price = Float.parseFloat(stringPrice);
                // check if user input  price is less than  0
                 if(price<0){
                 System.out.println("Total area must be greater than or equal to 0,input again!");
                  continue;
                } 
                return price;
               }
               
            } catch (NumberFormatException e) {
                System.out.println("Please input double number!");
            }
                       
        }
    }
    //Method used to input  date
    public Date inputDate(String mess) {
        Date expiryDate;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        //loop until user input correct expiry Date
        while (true) {
            try {
                System.out.println(mess);
                expiryDate = format.parse(input.nextLine());
                return expiryDate;
            } catch (ParseException e) {
                System.out.println("Date input is not valid!");
                System.out.println("Please enter date with format dd/MM/yyyy");
            }
        }
    }

   //Method used to input Date of manufacture
    public  Date inputDateOfManufacture(Date ExpiryDate) {
        Date dateOfManufacture,currentDate;
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String Now = dateNow.format(formatter);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        //loop until user input correct date of manufacture
        while (true) {
            try {
                currentDate=format.parse(Now);
                System.out.println("Enter Date Of Manufacture(Format: dd/MM/yyyy):");
                dateOfManufacture = format.parse(input.nextLine());
                //check if date of manufacture greater than current date or not
                if (currentDate.compareTo(dateOfManufacture)<0) {
                    System.out.println("The date of manufacture must not exceed the current date "+currentDate);
                    continue;
                }
                //check if Date of manufacture is greater than Expiry Date or not
                if (dateOfManufacture.compareTo(ExpiryDate) >= 0) {
                    System.out.println("The date of manufacture must be before the expiration date!");
                    continue;
                }
                return dateOfManufacture;
            } catch (ParseException e) {
                System.out.println("Date input is not valid!!!");
                System.out.println("Please enter date with format dd/MM/yyyy");
            }
        }
    }
    //Method used to input receipt date
    public Date inputReceiptDate(Date expiryDate, Date dateOfManufacture) {
        Date receiptDate,currentDate;
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateToday = dateNow.format(formatter);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        //loop until user input correct receipt date
        while (true) {
            try {
                currentDate= format.parse(dateToday);
                System.out.println("Enter Receipt Date: ");
                receiptDate = format.parse(input.nextLine());
                //check receipt date is between from Date Manufacture to Expiry Date or not
                if (receiptDate.compareTo(dateOfManufacture) < 0 || receiptDate.compareTo(expiryDate) > 0) {
                    System.out.println("Receipt date must between from Date Of Manufacture to Expiry Date!");
                  continue;
                }
                return receiptDate;
            } catch (ParseException e) {
                System.out.println("Date input is not valid!!!");
                System.out.println("Please enter date with format dd/MM/yyyy");
            }
        }
    }
    //Method used to input ID of product alrealy exist in the list
    public String inputIDExistInList(ArrayList<Product> listProduct) {
        ManagerProduct manager = new ManagerProduct();
        //regex to check ID of product is right format
        //condition: Alphabetic, number, space
        Pattern checkID = Pattern.compile("^[a-zA-Z0-9]+$");
        //loop until user input correct ID of product
        while (true) {
            System.out.print("Enter ID of Product: ");           String id = input.nextLine().replaceAll("\\s+", " ").trim();
            //check if user input a  empty ID
            if (id.isEmpty()) {
                System.out.println("ID is empty.Please input again!!!");
                // check if the entered string matches the condition in the regex 
            } else if (checkID.matcher(id).find()) {
                //Check if the user has entered the same ID or not
                if (manager.isDuplicateID(listProduct,id) == true) {
                    return id;
                } else {
                    System.out.println("ID of Product must exist in the list");
                }
            } else {
                System.out.println("The ID of Product can not contain"
                        + "special characters,for example:!,#,@...");
                System.out.println("Please input again");
            }
        }
    }
    //Method used to input choice ='Y'(Yes) or'N'(No)
    public String inputChoiceYN() {
        String choice;
        //loop until user input correct choice
        while (true) {
            System.out.println("Do you want to search more information(Y/N): ");
            choice = input.nextLine().replaceAll("\\s+", " ").trim();
            //check choice is empty or not
            if (choice.isEmpty()) {
                System.out.println("Please input not empty");
            } //check choice input not equal 'y' and 'n'  or not
            else if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
                return choice;
            } else {
                System.out.println("You need input Y(mean yes) or N(mean no)");

            }
        }

    }

}

