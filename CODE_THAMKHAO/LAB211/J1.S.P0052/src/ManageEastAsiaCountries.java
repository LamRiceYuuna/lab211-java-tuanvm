
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ManageEastAsiaCountries {


    // addCountryInformation
    public void addCountryInformation(ArrayList <EastAsiaCountries> list) {
        if (list.size() == 2) {
            System.out.println("Full country in list!");
            return;
        }
        while (list.size() < 2) {
            String code = "";
            //input code until no Duplicate code country
            while (true) {
                code = GetInput.getString("Enter code of country: ", "[A-Z]+$");// ID with letter uppercase 
                if (isExist(list,code)) {
                    System.out.println("Duplicate code, Please enter another Code");
                } else {
                    break;
                }
            }
            // name with letter uppercase or lower
            String name = GetInput.getString("Enter name of coutry: ", "[a-zA-z ]+");
            float area = GetInput.getFloat("Enter toral Area: ", 0, Float.MAX_VALUE);
            // terrain with letter uppercase or lower
            String terrain = GetInput.getString("Enter terrain of country: ", "[a-zA-Z ]+");
            // create new object
            EastAsiaCountries newCountry = new EastAsiaCountries(code, name, area, terrain);
            //add newcountry
            list.add(newCountry);

        }
        System.out.println("Add Successfully");
        
    }

    //check code isExist
    private boolean isExist(ArrayList <EastAsiaCountries> list,String code) {
//       int index = indexOfID(id); 
//       if (index != -1) {
//           return true;
//       }
//       return false;
        return (indexOfID(list, code) != -1);
    }

    // searchCountry
    public void searchCountry(ArrayList <EastAsiaCountries> list) {
        String keyword = GetInput.getString("Enter the name you want to search for: ", "[a-zA-Z ]+");
        int count = 0;
        System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        // traverse the list of countries from start to finish
        for (EastAsiaCountries o : list) {

            if (o.getCountryName().toLowerCase().contains(keyword.toLowerCase())) {

                count++;
                o.display();
                break;
            }
        }
        if (count == 0) {
            System.err.println("Not found country!");
        }
    }

    // funtion sort increase countryName
    public void sort(ArrayList <EastAsiaCountries> list) {
        System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        Collections.sort(list, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.countryName);
            }
        });
        for (EastAsiaCountries o : list) {
            o.display();
            System.out.println();
        }
    }

    // displayinformation of country
    public void displayinformation(ArrayList <EastAsiaCountries> list) {
        // Display all data
        int dataLength = list.size();  // size of the data
        if (list.size() == 0) {
            System.out.println("Data not exist");
        } else {
            System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");

            //loop to traverse the list of countries from start to finish
            for (int i = 0; i < dataLength; i++) {
                list.get(i).display();
                System.out.println();
            }

        }
    }

    private int indexOfID(ArrayList<EastAsiaCountries> list, String code) {
        for (int i = 0; i < list.size(); i++) {
            EastAsiaCountries countries = list.get(i);
            if (countries.getCountryCode().equalsIgnoreCase(code)) {//If there is any id that is equal to the id I passed, return the position of that id
                return i;
            }
        }
        return -1;
    }
    

}
