//Benjamin Chappell

public class IllegalRequestedCapacity extends RuntimeException
{
    public IllegalRequestedCapacity(String msg)
    {
        System.out.println(msg);
    }

    public IllegalRequestedCapacity()
    {
        String msg = "You cannot request a capacity less than the size of the array given.";
        System.out.println(msg);
    }
}