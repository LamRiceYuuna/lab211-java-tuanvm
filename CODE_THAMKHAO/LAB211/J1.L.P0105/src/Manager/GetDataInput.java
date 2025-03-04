package Manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetDataInput {

    public int inputChoose(String mgs, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        if (!mgs.isEmpty()) {
            System.out.println(mgs);
        }
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!raw.isEmpty()) { 
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Choice must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Choice must be an integer, enter again: ");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

    public String inputStorekeeperName() { 
        Scanner scanner = new Scanner(System.in);

        System.out.print("Storekeeper name: ");
        // loop until have valid name were inputted
        while (true) {
            String name = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!name.isEmpty()) { 
                if (isValidName(name)) {
                    return name;
                } else {
                    System.out.print("Storekeeper name can not contain special "
                            + "characters or digits, enter again: ");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.print("Name can not empty, enter again: ");
            }
        }
    }

    public int inputID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product ID: ");
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!raw.isEmpty()) { 
                try {
                    int id = Integer.parseInt(raw);
                    return id;
                } catch (NumberFormatException e) {
                    System.out.print("ID must be an integer, enter again: ");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.print("ID can not empty, enter again: ");
            }
        }
    }

    public String inputString(String mgs, String regex) {
        Scanner scanner = new Scanner(System.in);

        // loop until have valid name were inputted
        while (true) {
            System.out.print(mgs );
            String string = scanner.nextLine().trim();
            // not empty ~> finish;
            if (!string.isEmpty()) {
                if(string.matches(regex) && regex != ""){
                    return string;
                }else{
                    System.out.println(mgs + " can't have special characters");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.println(mgs + " can not empty, enter again");
            }
        }
    }

    public double inputPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Price: ");
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!raw.isEmpty()) { 
                try {
                    double price = Double.parseDouble(raw);
                    if (price > 0) {
                        return price;
                    } else {
                        System.out.print("Price must more than 0, enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Price must be a numberical value, enter again: ");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.print("Price can not empty, enter again: ");
            }
        }
    }

    public Date inputExpDate() {
        Scanner scanner = new Scanner(System.in);

        // loop until have valid name were inputted
        while (true) {
            System.out.print("Expiry Date: ");
            String raw = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!raw.isEmpty()) { 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);  
                    String result_str = sdf.format(date);
                    //compare with enter string
                    if (result_str.equals(raw)) {
                        return date;
                    } else {
                        System.out.println("Invalid enter date, enter again!");
                    }
                } catch (ParseException e) {
                    System.out.println("Expiry Date must in format dd/MM/yyyy, enter again!");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.println("Expiry Date can not empty, enter again!");
            }
        }
    }

    public Date inputManufactureDate(Date expDate) {
        Scanner scanner = new Scanner(System.in);

        // loop until have valid name were inputted
        while (true) {
            System.out.print("Manufacture date: ");
            String raw = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!raw.isEmpty()) { 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);  
                    String result_str = sdf.format(date);
                    //compare with enter string
                    if (result_str.equals(raw)) {
                        //compare with expdate
                        if (date.before(expDate)) {
                            Date now = new Date();
                            //compare with present date
                            if (!date.before(now)) {
                                System.out.println("Manufacture date must before today!");
                                continue;
                            }
                            return date;
                        } else {
                            System.out.println("Manufacture date must before "
                                    + "expiry date, enter again!");
                        }
                    } else {
                        System.out.println("Invalid enter date, enter again!");
                    }
                } catch (Exception e) {
                    System.out.println("Manufacture date must in format dd/MM/yyyy, enter again!");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.println("Manufacture date can not empty, enter again!");
            }
        }
    }

    public Date inputReceiptDate(Date manuDate, Date expDate) {
        Scanner scanner = new Scanner(System.in);

        // loop until have valid name were inputted
        while (true) {
            System.out.print("Receipt date: ");
            String raw = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!raw.isEmpty()) { 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);  
                    String result_str = sdf.format(date);
                    //compare with enter string
                    if (result_str.equals(raw)) {
                        //compare with expDate to confirm receipdaten after expDate
                        if (date.after(manuDate) ) {
                            return date;
                        } else {
                            System.out.println("Receipt date must "
                                    + "after manufacture date");
                            
                        }
                    } else {
                        System.out.println("Please enter a right date, enter again!");
                    }
                } catch (ParseException e) {
                    System.out.println("Receipt date must in format dd/MM/yyyy, enter again!");
                }
                // empty string ~> display error & re-enter
            } else { 
                System.out.println("Receipt date can not empty, enter again!");
            }
        }
    }

    private boolean isValidName(String name) {
        //Traverse from first to last of string name
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            //check letter and not space
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public String EoD() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            // not empty + satisfy conditions  ~> finish
            if (!string.isEmpty() && (string.equalsIgnoreCase("e") || (string.equalsIgnoreCase("d")))) { 
                return string;
                // empty string ~> display error & re-enter
            } else { 
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

    public boolean checkYesNo(String notification) {
        Scanner in = new Scanner(System.in);
        System.out.println(notification);
        System.out.print("Enter your choice: ");
        while (true) {
            String s = in.nextLine();
            if (!s.isEmpty()) {
                s = s.replaceAll(" ", "");
                if (s.compareToIgnoreCase("Y") == 0 || s.compareToIgnoreCase("y") == 0) {
                    return true;
                }
                if (s.compareToIgnoreCase("N") == 0 || s.compareToIgnoreCase("n") == 0) {
                    return false;
                }
                System.out.print("You must choose Yes(Y) or No(N)!\nEnter again: ");
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

}
