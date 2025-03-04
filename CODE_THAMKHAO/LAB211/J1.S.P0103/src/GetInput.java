
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

    public static Date checkDate(String mess) {

        // loop until have valid name were inputted
        while (true) {
            System.out.print(mess);
            String raw = sc.nextLine().trim();
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
                    System.out.println("Date must in format dd/MM/yyyy, enter again!");
                }
                // empty string ~> display error & re-enter
            } else {
                System.out.println(" Date can not empty, enter again!");
            }
        }
    }

}
