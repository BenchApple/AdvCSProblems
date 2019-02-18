public interface PriorityQueue<E extends Comparable<? super E>>
{
    public E min();
    public E deleteMin();
    public boolean insert(E data);
    public boolean isEmpty();
    public boolean isFull();
    public int size();
}