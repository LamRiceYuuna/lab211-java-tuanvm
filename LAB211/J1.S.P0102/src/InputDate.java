
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class InputDate {

    private static Scanner sc = new Scanner(System.in);

    public static String getDateString() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateString;
        System.out.print("Please enter date with format [dd/mm/yyyy]: ");
        while (true) {
            try {

                dateString =getString("^\\d{2}[/]\\d{2}[/]\\d{4}$");
                date = dateFormat.parse(dateString);
                break;
            } catch (ParseException e) {
                System.err.print("Invalid date input! Date input format is dd/MM/yyyy ! Pls re-enter: ");
            }

        }
        return dateString;
    }

    static boolean checkExits(String dateString) {
        String formatString = "dd/MM/yyyy";
        while (true) {

            try {
                SimpleDateFormat format = new SimpleDateFormat(formatString);
                format.setLenient(false);
                format.parse(dateString);
            } catch (ParseException e) {
                return false;
            } catch (IllegalArgumentException e) {
                return false;
            }

            return true;
        }

    }

    static void determineDay(String dateString, boolean checkDate) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        if (checkDate) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
            System.out.print("Your day is " + simpleDateFormat.format(dateformat.parse(dateString)));
        } else {
            System.out.println("The date not exist!");
        }
    }

    // Xét chuỗi nhập có đúng dạng regex k
    public static String getString(String Regex) {
        String result = "";
       
        while (true) {
            result = sc.nextLine();
            if (result.trim().equals("")) {
                System.err.print("Can not be empty! Re-Enter: ");
                continue;
            }
            if (result.matches(Regex)) {
                return result.trim();
            }
            System.err.print("Invalid! Re-Enter: ");
        }
    }

}
