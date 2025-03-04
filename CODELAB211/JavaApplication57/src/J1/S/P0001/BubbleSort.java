/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0001;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BubbleSort {


    /*Fuction to create a array with size array from function 
    InputAPositiveDecimalNumber*/
    int[] CreateAArray(int size_array) {
        int[] array = new int[size_array];
        return array;
    }

    //Function to generate random integer in number range for each array element
    int[] GenerateRandomIntegerNumber(int[] array) {
        Random rd = new Random();
        int size_array = array.length;
        //loop to random integer in number range for each array element
        for (int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(size_array);
        }
        return array;
    }

    //Function to display all element of array
    void display(int[] array, String msg) {
        if (msg.equals("Unsorted array: ")) {
            System.out.print(msg);
            System.out.println(Arrays.toString(array));
        } else if (msg.equals("Sorted array: ")) {
            System.out.print(msg);
            System.out.print(Arrays.toString(array));
        } else if (msg.equals("")) {
            System.out.print(msg);
            System.out.print(Arrays.toString(array));
        }
    }

    //Function to sort all elements array by bubble sort
    void bubbleSort(int[] array) {
        int size_array = array.length;
        /*loop to access from the first element to the element before the last 
        one */
        for (int i = 0; i < size_array - 1; i++) {
            /*loop to acces from the firt element to the last element unsort of
            array*/
            for (int j = 0; j < size_array - 1 - i; j++) {
                display(array, "");
                // compare 2 adjacent elements
                /*if previous element is greater than the next element*/
                if (array[j] > array[j + 1]) {                    
                    System.out.println("     " + array[j] + ">" + array[j + 1] + 
                            ", swap");                    
                    //swap 2 adjacent elements
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                } else if (array[j] < array[j + 1]) {
                    System.out.println("     " + array[j] + "<" + array[j + 1] + 
                            ", ok");
                } else {
                    System.out.println("     " + array[j] + "=" + array[j + 1] + 
                            ", ok");

                }
            }
            System.out.println("");
        }
    }
}
