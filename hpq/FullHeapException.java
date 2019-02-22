//Benjamin Chappell

public class FullHeapException extends RuntimeException
{
    public FullHeapException(String msg)
    {
        System.out.println(msg);
    }

    public FullHeapException()
    {
        String msg = "The heap is currently full. You cannot insert any more elements into this heap as it has reached its capacity.";
        System.out.println(msg);
    }
}