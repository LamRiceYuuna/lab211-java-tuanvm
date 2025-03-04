
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
    
    public static int getInt(String Mess, int MIN, int MAX){
        int num = 0;
        System.out.println(Mess);
        while(true){
            try{
                num = Integer.parseInt(sc.nextLine());
                if(num >= MIN && num <= MAX){
                    return num;
                }
                System.err.print("Out of range [" + MIN + ", " + MAX + "]! Re- Enter: ");
            }
            catch(Exception e){
                System.err.print("Invalid! Re-enter: ");
            }
        }
    }
    
    public static String getString(String Mess, String Regex){
        String result = "";
        System.out.println(Mess);
        while(true){
            result = sc.nextLine();
            if(result.trim().equals("")){
                System.err.println("Can not be empty! Re-Enter: ");
                continue;
            }
            if(result.matches(Regex)){
                return result;
            }
            System.err.println("Invalid! Re-Enter: ");
        }
    }
    
    public static float getFloat(String Mess, float MIN, float MAX){
        float num = 0;
        System.out.println(Mess);
        do{
            try{
                num = Float.parseFloat(sc.nextLine());
                if(num > MIN && num < MAX){// lớn hơn min và bé hơn max
                    return num;
                }
                System.out.println("Out of range [" + MIN + ", " + MAX + "]! Re- Enter: ");
            }catch(Exception e){
                System.err.println("Invalid! Re- Enter: ");
            }
        }while(true);
    }
}
