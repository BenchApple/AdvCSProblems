//Benjamin Chappell

import java.util.Scanner;

public class BucketSort
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("How many elements would you like the the list you would like to sort: ");
        int len = keyboard.nextInt();
        
        int[] list = new int[len];
        
        for (int i = 0; i < len; i++)
        {
            System.out.println("What Integer would you like next in your array? ");
            list[i] = keyboard.nextInt();
        }
        
        System.out.println("We will now sort your array for you using Bucket Sort :)");
        System.out.println();
        
        bucketSort(list);
        
        for (int i : list) //Print out each element on its own line.
        {
            System.out.println(i);
        }
    }
    
    /* 
     * The actual sorting algoritm. Gets the min and max of the list. Allocates space for a list of size max - min + 1.
     * Goes through the list and increments the elements spot in the counter array by one for each occurence of the 
     * element. Iterates through the counter array and places each element in its proper spot in the original array. 
     */
    public static void bucketSort(int[] list) 
    {
        int max = list[0];
        int min = list[0];
        
        for (int i = 1; i < list.length; i++) //Find the max and min of the list.
        {
            if (list[i] > max) 
                max = list[i];
            else if (list[i] < min)
                min = list[i];
        }
        
        int[] counterArray = new int[max - min + 1]; //Initialize a counter array to count each occurence of each element.
        
        for (int i : list) //Iterate through the original array, adding one to the index of the element in counter.
        {
            counterArray[i - min]++;
        }
        
        int tracker = 0; //Keeps track of where we are placing the elements in the original array.
        for (int i = 0; i < counterArray.length; i++) //Iterate through the counter array to place each element in their spot in the original array.
        {
            for (int j = 1; j <= counterArray[i]; j++) //Makes sure dupicate elements are replaced the correct amount of times.
            {
                list[tracker] = i + min; //Places the element in its correct spot in the original array.
                tracker++; 
            }
        }
    }
}

