
import java.util.Scanner;

public class GetInput {
    private static Scanner sc = new Scanner(System.in);
    //  check if the input number is an integer
    public static int getIntput(String Mess, int MIN, int MAX) {
        System.out.println(Mess);
        int sizeArray = 0;
        // loop use try catch to check input
        while(true){
            try{
                
                sizeArray = Integer.parseInt( sc.nextLine());// not correct meet exception and jump to catch
                if(sizeArray >= MIN && sizeArray <= MAX){
                    return sizeArray;
                }
                System.out.print("Out of range [" + MIN + ", " + MAX + "]! Pls re- Enter: ");// is integer but not in MIN MAX
            }
            catch(NumberFormatException e){
                System.out.print("The number of array must be positive integer!"
                        + "Pls re-enter: ");
            }
        }
    }
    
    
}
