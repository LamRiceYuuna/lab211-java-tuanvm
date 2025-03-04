
import java.text.ParseException;



public class main {

    public static void main(String[] args) throws ParseException {
        boolean isRepeated;
        do {
        // User enter date with [dd/mm/yyyy] format 
        String dateString = InputDate.getDateString();
        // Check user input date exits
        boolean checkDate=InputDate.checkExits(dateString);
        // Determine day of week with input date
        InputDate.determineDay(dateString,checkDate);
        System.out.println();
        //Ask user if they want to repeat the process
        isRepeated = Validation.checkRepeat();
        } while (isRepeated);
    
    }

    
    
}
//Date d = util.checkDate("enter date: ", "dd/MM/yyyy");
//        System.out.println(util.dayOfWeek(d));
//    Date d = Validation.getDate("Please enter date with format [dd/mm/yyyy]: ", "dd/MM/yyyy", "^\\d{2}[/]\\d{2}[/]\\d{4}$");
//}
