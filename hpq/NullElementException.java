//Benjamin Chappell

public class NullElementException extends RuntimeException
{
    public NullElementException(String msg)
    {
        super("The heap cannot store null elements. Do not attempt to add Null Elements to the heap.");
    }

    public NullElementException()
    {
        super();
    }
}