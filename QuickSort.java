//Benjamin Chappell

import java.util.Scanner;

public class QuickSort
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
        
        System.out.println("We will now sort your array for you using Quick Sort :)");
        System.out.println();
        
        quickSort(list);
        
        for (int i : list)
        {
            System.out.println(i);
        }
    }
    
    //Use a public shell method so that recursion is possible.
    public static void quickSort(int[] array)
    {
        quickSort(array, 0, array.length - 1);
    }
    
    //Recursive Sorting used here.
    private static void quickSort(int[] array, int start, int end)
    {
        if (start < end)
        {
            int endOfFirstPart = partition(array, start, end); //Find the end of the first part based on a pivot, being the first element. 
            quickSort(array, start, endOfFirstPart); //Sort the first half of the Array.
            quickSort(array, endOfFirstPart + 1, end); //Sort the second half of the Array.
        }
    }
    
    //Make it so that all elements of the first part of the list are less than those in the second part of the list.
    private static int partition(int[] array, int start, int end)
    {
        int leftFinger = start - 1;
        int rightFinger = end + 1;
        int pivot = array[start];
        
        while (true)
        {
            do
            {
                leftFinger++;
            } while (array[leftFinger] < pivot);
        
            do
            {
                rightFinger--;
            } while (array[rightFinger] > pivot);
        
            if (leftFinger >= rightFinger)
            {
                return rightFinger;
            }
            else
            {
                int temp = array[leftFinger];
                array[leftFinger] = array[rightFinger];
                array[rightFinger] = temp;
            }
        }
    }
}
