//Benjamin Chappell

public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    private E[] heap;
    private int size;
    private int capacity;

    public HeapPriorityQueue(E[] requestedArray, int requestedCapacity) throws IllegalRequestedCapacity
    {
        if (requestedCapacity < requestedArray.length)
            throw new IllegalRequestedCapacity();

        capacity = requestedCapacity;
        size = requestedArray.length;
        heap = (E[])(new Comparable[capacity + 1]);

        for (int i = 0; i < requestedArray.length; i++)
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
        this((E[])(new Comparable[1]), requestedCapacity);
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

    public E min() throws EmptyHeapException
    {
        if (!isEmpty())
            return heap[1];   
        else   
        {
            throw new EmptyHeapException();
        } 
    }

    public E deleteMin() throws EmptyHeapException
    {
        if (!isEmpty())
        {
            E tempMin = heap[1];
            heap[1] = heap[size];
            size -= 1;

            heapify(heap, 1);
            return tempMin;
        }
        else
        {
            throw new EmptyHeapException();
        }
    }

    public boolean insert(E data) throws FullHeapException
    {
        if (!isFull())
        {
            size += 1;
            heap[size] = data;
            buildHeap(heap);
            return true;
        }
        else
        {
            throw new FullHeapException();
            //return false;
        }
    }

    public boolean isEmpty()
    {
        if (size < 1)
            return true;
        return false;
    }

    public boolean isFull()
    {
        if (size >= capacity)
            return true;
        return false;
    }

    public int size()
    {
        return size;
    }
}