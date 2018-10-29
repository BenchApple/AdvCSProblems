//Benjamin Chappell

public class bucketSort
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
        
        bucketSort(list);
        
        for (int i : list)
        {
            System.out.println(i);
        }
    }
    
    public static void bucketSort(int[] list)
    {
        int max = list[0];
        int min = list[0];
        
        for (int i = 1; i < length(list); i++)
        {
            if (list[i] > max)
            {
                max = list[i]
            }
        }
    }
}
