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
        if (2*index <= size && heap[2*1].compareTo(heap[index]) < 0)
            smallest = 2*index;
        else
            smallest = index;

        if (2*index + 1 <= size && heap[2*index+1].compareTo(heap[smallest]) < 0)
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
            /*for (E i : heap)
            {
                System.out.println(i);
            }
            System.out.println(size);
            System.out.println(heap[size]);*/
            heap[1] = heap[size - 1];
            heap[size] = null;
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
            heap[size] = data;
            int i = size;
            size += 1;
            
            while (i > 1 && heap[i].compareTo(heap[i/2]) < 1)
            {
                E temp = heap[i];
                heap[i] = heap[i/2];
                heap[i/2] = temp;

                i /= 2;
            }

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