/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0001;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {
    //Function to input a positive decimal number
    int InputAPositiveDecimalNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        int size_array;
        //loop to users input correct a positive decimal number
        while (true) {
            try {
                System.out.println(msg);               
                size_array = Integer.parseInt(sc.nextLine().trim());
                //size array with for range (0,MAX_INTEGER]
                if (size_array <= 0 || size_array > Integer.MAX_VALUE) {
                    throw  new NumberFormatException();                        
                    //throw exception    
                }return size_array;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number,please input a positive "
                        + "decimal number ");
            }
        }
    }
}
