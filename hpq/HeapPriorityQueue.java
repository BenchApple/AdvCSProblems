public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    private E[] heap;
    private int size;
    private int capacity;

    public HeapPriorityQueue(E[] requestedArray, int requestedCapacity)
    {
        if (requestedCapacity < requestedArray.length)
            //Throw IllegalRequestedCapacityException

        capacity = requestedCapacity;
        size = requestedArray.length;
        heap = (E[])(new Comparable[capacity + 1]);

        for (int i = 0; i < requestedArray.length + 1; i++)
        {
            heap[i + 1] = requestedArray[i];
        }

        buildHeap(heap);
    }

    public HeapPriorityQueue(E[] requestedArray)
    {
        this(requestedArray, requestedArray.length);
    }

    public HeapPriorityQueue(int requestedCapacity)
    {
        this((E[])(new Comparable[0]) , requestedCapacity);
    }

    private void buildHeap(E[] heap)
    {
        for (int i = size / 2; i >= 1; i++)
        {
            heapify(heap, i);
        }
    }

    private void heapify(E[] heap, int index)
    {
        int smallest;
        if (2*index <= heap.length && heap[2*1].compareTo(heap[index]) < 0)
            smallest = 2*index;
        else
            smallest = index;

        if (2*index + 1 <= heap.length && heap[2*index+1].compareTo(heap[smallest]) < 0)
            smallest = 2*index + 1;

        if (smallest != index)
        {
            E temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            heapify(heap, smallest);
        }
    }

    public E min()
    {
        return heap[1];    
    }

    public E deleteMin()
    {
        
    }

    public boolean insert(E data)
    {
        return false;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public boolean isFull()
    {
        return false;
    }

    public int size()
    {
        
    }
}