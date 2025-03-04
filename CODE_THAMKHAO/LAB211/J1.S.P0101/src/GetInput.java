
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
public class GetInput {

    private static Scanner sc = new Scanner(System.in);

    //  check if the input number is an integer
    public static Integer getInt(String Mess, int MIN, int MAX, String ignore) {
        int num;
        System.out.print(Mess);
        while (true) {
            try {

                String string = sc.nextLine();
                if (ignore != null && string != null && string.trim().equals(ignore)) {// bỏ qua
                    return null;
                }
                num = Integer.parseInt(string);
                if (num >= MIN && num <= MAX) {
                    return num;
                }
                System.err.print("Out of range [" + MIN + ", " + MAX + "]! Re- Enter: ");
            } catch (NumberFormatException e) {
                System.err.print("Invalid! Re-enter: ");
            }
        }
    }

    //getDouble
    public static Double getDouble(String Mess, double MIN, double MAX, String ignore) {
        Double num;
        System.out.print(Mess);
        String string = sc.nextLine();
        do {
            try {
                if (ignore != null && string != null && string.trim().equals(ignore)) {// bỏ qua
                    return null;
                }
                num = Double.parseDouble(string);
                if (num >= MIN && num <= MAX) {
                    return num;
                }
                System.err.print("Out of range [" + MIN + ", " + MAX + "]! Re- Enter: ");
            } catch (NumberFormatException e) {
                System.err.print("Invalid! Re- Enter: ");
            }
        } while (true);
    }

    //getString
    public static String getString(String Mess, String Regex, String ignore) {
        System.out.print(Mess);
        while (true) {
            try {

                String string = sc.nextLine();
                if (ignore != null && string != null && string.trim().equals(ignore)) {// bỏ qua
                    return null;
                }
                if (string.matches(Regex)) {
                    return string;
                }
            } catch (NumberFormatException e) {
                System.out.println("Meet IOException");
            }
            System.err.print("Invalid! Re-Enter: ");

        }
    }

    //getDate
    public static Date getDate(String mess, String format, String regex, String ignore) {
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat(format);
        // check 31/02
        sd.setLenient(false);// 
        System.out.print(mess);
        while (true) {

            try {
                String input = sc.nextLine();
                if (ignore != null && input != null && input.trim().equals(ignore)) {
                    return null;
                }
                if (input.isEmpty()) {
                    System.out.println("Can't leave this field blank");
                } else {
                    date = sd.parse(input);
                    Date todayDate = sd.parse(sd.format(new Date()));
                    
                    // ensure dob is after current date
                    if (date.before(todayDate)) {
                        return date;
                    } else {
                        System.out.println("Error: DOB is after current date");
                    }
                    
                }
            } catch (ParseException e) {
                System.err.print("Invalid date input! Date input format is " + format + "! Pls re-enter: ");
            }
        }
    }

    //transmitted on a specified date
    public static Date toDate(String txt, String format) {

        try {

            SimpleDateFormat sd = new SimpleDateFormat(format);
            // check 31/02
            sd.setLenient(false);//
            Date date = sd.parse(txt);
            return date;
        } catch (ParseException e) {
            System.err.print("Invalid date input! Date input format is " + format + "! Pls re-enter: ");
        }
        return null;
    }

    // change date to string and print
    public static String toString(Date date, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        return sd.format(date);
    }
}
