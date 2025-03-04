
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    
    //  main
    public static void main(String[] args) {
        // Step1: getInput sizeArray 
        int sizeArray = GetInput.getIntput("Enter number of array: ", 1, Integer.MAX_VALUE);
        int arr[] = new int[sizeArray];
        // test algorthm
        //int arr[] = {5, 1, 12, -5, 16};

        // Step2: Generate randomArray 
        randomArray(arr);
        
        // Step3: display Unsortarray
        display("Unsorted array: ", arr);
        System.out.println();

        // Step4: bubbleSort
        bubbleSort(arr);

        //Step5: display Sortedarray
        display("Sorted array: ", arr);
    }

    //funtion randomarray
    private static void randomArray(int[] arr) {
        Random random = new Random();
        //iterate from index =0 to long array-1
        for (int i = 0; i < arr.length; i++) {// i is each index
            arr[i] = random.nextInt(arr.length);// radom  0 to a.length-1

        }

    }

    //funtion swap
    public static void swap(int[] arr, int i, int j) {
        // Swap elements at position i and j in array
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // funtion bubbleSort
    public static void bubbleSort(int[] arr) {
        // loop runs from beginning to end arr
        for (int i = 0; i < arr.length; i++) {
            // loop run from the beginning of the array to the last element of the unsorted array
            for (int j = 0; j < arr.length - i - 1; j++) {
                display("", arr);
                // compare 2 adjacent elements
                if (arr[j] > arr[j + 1]) {
                    System.out.println("\t" + arr[j] + ">" + arr[j + 1] + ", swap");
                    //call the swap function if the first true element is greater than the second
                    swap(arr, j, j + 1);

                } else {
                    System.out.println("\t" + arr[j] + "<" + arr[j + 1] + ", ok");
                }

            }
            System.out.println();

        }
    }

    // display
    public static void display(String mess, int[] arr) {
        System.out.print(mess);
        System.out.print(Arrays.toString(arr));
    }
}
