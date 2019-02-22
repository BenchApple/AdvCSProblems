//Benjamin Chappell

public class EmptyHeapException extends RuntimeException
{
    public EmptyHeapException(String msg)
    {
        System.out.println(msg);
    }

    public EmptyHeapException()
    {
        String msg = "The heap is currently empty. You cannot access or remove the minimum element of this heap due to it not existing.";
        System.out.println(msg);
    }
}