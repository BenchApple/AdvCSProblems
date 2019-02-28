//Benjamin Chappell

public class NullElementException extends RuntimeException
{
    public NullElementException(String msg)
    {
        System.out.println(msg);
    }

    public NullElementException()
    {
        String msg = "The heap cannot store null elements. Do not attempt to add Null Elements to the heap.";
        System.out.println(msg);
    }
}