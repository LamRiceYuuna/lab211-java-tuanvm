
import java.util.Date;

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
       
        // enter date1
        Date date1 = GetInput.checkDate("Please enter the first date: ");
        //enter date2
        Date date2 = GetInput.checkDate("Please enter the second date: ");
        // compare and display
        compareDisplay(date1, date2);
        
       
    }

    private static void compareDisplay(Date date1, Date date2) {
        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
        } else if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("Date1 and Date2 are the same");
        }
    } 
}
