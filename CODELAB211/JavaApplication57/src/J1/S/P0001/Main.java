/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0001;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        
    BubbleSort bs = new BubbleSort(); 
    Validation v = new Validation();
    //Step 1: Input a positive decimal number for size array
    //int size_array = v.InputAPositiveDecimalNumber("Enter number of array:");
    //Step 2: Create a array with size array
    //int [] array = bs.CreateAArray(size_array);
    //Step 3: Generate random integer in number range for each array element
    //int [] array1 = bs.GenerateRandomIntegerNumber(array);
    //Step 4: Display all element of array before sort
    //bs.display(array1, "Unsorted array: ");
    //Step 5: Sort array by bubble sort
    int [] array2 = {5, 1, 12, -5, 16}; 
    //bs.bubbleSort(array1);
    bs.bubbleSort(array2);
    bs.display(array2, "");
    //Step 6: Display all element of array after sort
    //bs.display(array1, "Sorted array: ");
    }    
}
