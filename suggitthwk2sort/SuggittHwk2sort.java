/*
 * Sorts a list of random numbers from a text file using shell sort. Prints information as it works.
 */
package suggitthwk2sort;

import java.util.Scanner;
import java.io.*;

/**
 * @date 11/11/18   (removed and modified some things before making it public - 6/15/21)
 * @author Travis Suggitt
 */
public class SuggittHwk2sort {
    /**
     * Reads the amount of number to be sorted from the user and sends an array of that size to sort method and finally
     * prints the sorted list.
     *
     * @param args
     */
    public static void main(String[] args) {
        final String FILENAME = "[FILENAME]";
        int i = 0;
        int arraySize = 0;
        
        System.out.print("This program will implement a Shell sort");
        System.out.println();
        System.out.println();
        
        try {
            File sourceFile = new File(FILENAME);
            Scanner fileInput = new Scanner(sourceFile);
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter the list size (12 to 99): ");
            
            while (arraySize < 12 || arraySize > 99) {
                arraySize = userInput.nextInt();
                System.out.println();
                if (arraySize < 12 || arraySize > 99) {
                    System.out.println("You entered a number that was not between 12 to 99, try again!");
                }
            }
            
            int array[] = new int[arraySize];

            while (fileInput.hasNext() && i < arraySize) {
                array[i] = fileInput.nextInt();  
                i++;
            }
            
            sort(array);
            
            System.out.println("    Final Sorted List: ");
            for (i = 0; i < array.length; i++){
                System.out.print("    [" + i + "]" + array[i] + "  ");
            }
            
        } catch (IOException e) {
            System.out.println("Error: File not found!");
        }
    }

    /**
     * Performs all sorting of the array and prints what is happening in the function to the console
     *
     * @param array array containing unsorted integers
     */
    public static void sort(int array[]) {
        int pass = 1;
        int gap = array.length / 2;
        int i;
        int j;
        int temp;
        
        while (gap > 0) {
            System.out.println("FOR PASS " + pass + ":  gap = " + gap + "   start index = " + gap);
            System.out.println();
            System.out.println("    LIST AT START OF PASS:");
            for (i = 0; i < array.length; i++){
                System.out.print("    [" + i + "]" + array[i] + "  ");
            }
            System.out.println();
            System.out.println();
            
            for (i = gap; i < array.length; i++){
                j = i;
                temp = array[i];
                
                System.out.println("Insert Value: " + array[i]);
                System.out.print("  COMPARE:  [" + i + "]" + array[i] + " < [" + (i - gap) + "]" + array[i - gap]
                        + "  ?  ");
                
                if (array[i] > array[i - gap]) {
                    System.out.print("No");
                    System.out.println();
                    System.out.println("  Already inserted in correct place");
                } else {
                    System.out.print("Yes - MOVE " + array[i - gap] + " to index [" + i + "]");
                    System.out.println();
                    System.out.println("  Insert " + array[i] + " at index [" + (i-gap) + "]");
                }

                System.out.println();

                while (j >= gap && array[j - gap] > temp){
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = temp;
            }
            gap = gap / 2;
            pass++;
        }
    } 
}
