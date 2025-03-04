
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ManageEmployee {


    
    // addEmployee
    public void addEmployee(ArrayList<Employee> list) {

        String id = "";

        while (true) {
            id = GetInput.getString("Enter id: ", "[A-Z0-9]+", null);
            if (isExist(list,id)) {
                System.out.println("Duplicate code, Please enter another Code");
            } else {
                break;
            }
        }
        String firstName = GetInput.getString("Enter First Name: ", "[a-zA-Z ]+", null);// enter firstname with letter
        String lastName = GetInput.getString("Enter Last Name: ", "[a-zA-Z ]+", null);// lastname with letter
        String phone = GetInput.getString("Enter Phone: ", "^0\\d{9}+$", null);// phone with start 0 and after {0-9} with 9 numbers
        String email = GetInput.getString("Enter Email: ", "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$", null);// email start letter after numbers or letter +@ numbers or letter
        String address = GetInput.getString("Enter Address: ", "[a-zA-Z ]+", null);// enter address letter 
        Date dob = GetInput.getDate("Enter DOB: ", "dd/MM/yyyy", "^\\d{2}[/]\\d{2}[/]\\d{4}$", null); // add date
        String sex = GetInput.getString("Enter Sex: ", "^(male|female)$", null);// add sex
        double salary = GetInput.getDouble("Enter Salary: ", 0, Double.MAX_VALUE, null);// add salary
        String agency = GetInput.getString("Enter Agency: ", "[a-zA-Z ]+", null);// add agency
        list.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency));
        System.out.println("Add new employee successfull");
    }

    //check id isExist
    public boolean isExist(ArrayList<Employee> list,String id) {
       int index = indexOfID(list, id); 
       if (index != -1) {
           return true;
       }
       return false;
    }

// updateEmployee
    public void updateEmployee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        String id = GetInput.getString("Enter id: ", "[A-Z0-9]+", null);
        int index = indexOfID(list, id);

        if (index != -1) {
            Employee employee = list.get(index);// tìm thấy đối tượng trước khi update
            final String IGNORE_STR = "";
            while (true) {
                id = GetInput.getString("Enter new ID: ", "[A-Z0-9]+", null);
                if (indexOfID(list, id) != -1 && !id.equals(employee.getId())) {
                    System.out.println("This Id is already used by another employee");
                } else {

                    break;
                }

            }
            String firstName = GetInput.getString("Enter First Name: ", "^[a-zA-Z ]+$", IGNORE_STR);
            String lastName = GetInput.getString("Enter Last Name: ", "^[a-zA-Z ]+$", IGNORE_STR);
            String phone = GetInput.getString("Enter Phone: ", "^0\\d{9}+$", IGNORE_STR);
            String email = GetInput.getString("Enter Email: ", "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$", IGNORE_STR);
            String address = GetInput.getString("Enter Address: ", "^[a-zA-Z -]+$", IGNORE_STR);
            Date dob = GetInput.getDate("Enter DOB: ", "dd/MM/yyyy", "^\\d{2}[/]\\d{2}[/]\\d{4}$", IGNORE_STR);
            String sex = GetInput.getString("Enter Sex: ", "^(male|female)$", IGNORE_STR);
            Double salary = GetInput.getDouble("Enter Salary: ", 0, Double.MAX_VALUE, IGNORE_STR);
            String agency = GetInput.getString("Enter Agency: ", "^[a-zA-Z ]+$", IGNORE_STR);
            if (id != null) {
                employee.setId(id);
            }
            if (firstName != null) {
                employee.setFirstName(firstName);
            }
            if (lastName != null) {
                employee.setLastName(lastName);
            }
            if (phone != null) {
                employee.setPhone(phone);
            }
            if (email != null) {
                employee.setEmail(email);
            }
            if (address != null) {
                employee.setAddress(address);
            }
            if (dob != null) {
                employee.setDob(dob);
            }
            if (sex != null) {
                employee.setSex(sex);
            }
            if (salary != null) {
                employee.setSalary(salary);
            }
            if (agency != null) {
                employee.setAgency(agency);
            }
        } else {// not found
            System.out.println("Id not found");
            System.out.println("Update employee fail!");
        }
        System.out.println();
    }

    // removeEmployee
    public void removeEmployee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        String id = GetInput.getString("Enter ID: ", "[A-Z0-9]+", null);
        int index = indexOfID(list, id);//pass in id
        if (index != -1) {// exist
            list.remove(index);
            System.out.println("Delete employee successful!");
        } else {
            System.out.println("Id not found");
            System.out.println("Delete employee fail!");
        }
    }

    // searchEmployee
    public void searchEmplyee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        String name = GetInput.getString("Enter Name: ", "^[a-zA-Z ]+$", null);// firt + last
        System.out.println("List Employee: ");
        // Check name is exist?
        boolean isExisted = false;
        for (Employee e : list) {
            String fullName = e.getFirstName() + " " + e.getLastName();
            if (fullName.contains(name)) {
                if (!isExisted) {
                    System.out.format("%-15s%-15s%-20s%-20s%-20s%-20s%-20s%-10s%-20s%-20s\n",
                            "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency");
                }
                isExisted = true;
                System.out.println(e);
            }
        }
        if (!isExisted) {
            System.out.println("Not Found");
        }
    }


    // sortEmployee by salary
    public void sortEmployee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("List empty");
            return;
        }

        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
//                // if (d1 < d2)
//                return -1;
//                if (d1 > d2) {
//                    return 1;
//                }

                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });
    }

    // displayEmployee
    public void displayEmployee(ArrayList<Employee> list) {
        System.out.format("%-15s%-15s%-20s%-20s%-20s%-20s%-20s%-10s%-20s%-20s\n",
                "ID", "First Name", "Last Name", "Phone Num", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (Employee E : list) {
            System.out.println(E);
        }
    }

    //find id's location
    private int indexOfID(ArrayList<Employee> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getId().equalsIgnoreCase(id)) {//If there is any id that is equal to the id I passed, return the position of that id
                return i;
            }
        }
        return -1;
    }

    

}
