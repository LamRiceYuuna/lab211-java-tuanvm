package j1.s.p0063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManagerPerson {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //Step 1. Allow user enter size of array
        int sizeArray = sizeOfArray();

        //Step 2. Input information of person
        Person[] personArray = new Person[sizeArray];
        Person[] personInfor = inputPersonInfo(personArray, sizeArray);

        //Step 3. Display all information of person entered
        displayAllPersonInfor(personArray, sizeArray);

        //Step 4. sort by Salary
        sortBySalary(personArray, sizeArray);
        displayAllPersonInfor(personArray, sizeArray);

    }

    private static int sizeOfArray() {
        int sizeArray;
        //Loop until user enter true value
        while (true) {
            System.out.print("Please input size of array: ");
            try {
                sizeArray = Integer.parseInt(in.readLine());
                //if size of array greate than zero that break else show messege for user
                if (sizeArray > 0) {
                    break;
                } else {
                    System.out.println("Size of array must be greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Size of array must be an integer.");
            }
        }
        return sizeArray;
    }

    private static Person[] inputPersonInfo(Person[] personArray, int sizeArray) throws IOException {
        //Create person of array
        System.out.println("=====Management Person programer=====");
        for (int i = 0; i < sizeArray; i++) {
            System.out.println("Input Information of Person ");
            String name = inputName();
            String address = inputAddress();
            double salary = inputSalary();
            Person person = new Person(name, address, salary);
            personArray[i] = person;
        }
        return personArray;
    }

    private static void displayAllPersonInfor(Person[] personArray, int sizeArray) {
        for (int i = 0; i < personArray.length; i++) {
            personArray[i].displayPersonInfor();
        }
    }

    private static void sortBySalary(Person[] personArray, int sizeArray) {
        //run first postion to last positon of array
        for (int i = 0; i < personArray.length; i++) {
            //run second postion to last positon of array
            for (int j = i + 1; j < personArray.length; j++) {
                //If person of array at position i have salary is greater than person of array at position j that we swap
                if (personArray[i].getSalary() > personArray[j].getSalary()) {
                    //Swap position
                    Person temp = personArray[i];
                    personArray[i] = personArray[j];
                    personArray[j] = temp;
                }

            }
        }
    }

    private static String inputName() throws IOException {
        String name;
        //Loop until user enter name, can't be blank 
        while (true) {
            System.out.print("Please input name: ");
            name = in.readLine().trim();
            //if name that user enter is blank show messege for user, else break.
            if (name.isEmpty()) {
                System.out.println("Name can not be blank.");
            } else {
                break;
            }
        }
        return name;
    }

    private static String inputAddress() throws IOException {
        String address;
        //Loop until user enter address, can't be blank
        while (true) {
            System.out.print("Please input address: ");
            address = in.readLine().trim();
            //if address that user enter is blank show messege for user, else break.
            if (address.isEmpty()) {
                System.out.println("Address can not be blank.");
            } else {
                break;
            }
        }
        return address;
    }

    private static double inputSalary() {
        double salary;
        //Loop until user enter true value
        while (true) {
            System.out.print("Please input salary: ");
            try {
                salary = Double.parseDouble(in.readLine());
                //if salary that user enter is greater than zero break, else show messege for user.
                if (salary > 0) {
                    break;
                } else {
                    System.out.println("Salary is greater than zero");
                }
            } catch (Exception e) {
                //salary user enter not an integer show messege for user.
                System.out.println("You must input digit.");
            }
        }
        return salary;
    }

}
