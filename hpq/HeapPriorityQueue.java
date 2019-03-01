import javax.lang.model.util.ElementScanner6;

//Benjamin Chappell

public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    private E[] heap;
    private int size;
    private int capacity;

    public HeapPriorityQueue(E[] requestedArray, int requestedCapacity) 
    {
        //Throw an exception when capacity is less than the array length.
        if (requestedCapacity < requestedArray.length) 
            throw new IllegalRequestedCapacity();

        capacity = requestedCapacity;
        size = requestedArray.length;
        //Cast a comparable array to type E, java being stupid again.
        heap = (E[])(new Comparable[capacity + 1]); 

        //Transfer each element from the requested array to the heap.
        for (int i = 0; i < requestedArray.length; i++) 
        {
            //Throw error if there is a null element in the array.
            if (requestedArray[i] == null)
                throw new NullElementException();

            heap[i + 1] = requestedArray[i];
        }

        buildHeap(heap);
    }

    //Create a heap from just an array. Use the length of the array as the capacity of the heap.
    public HeapPriorityQueue(E[] requestedArray)
    {
        this(requestedArray, requestedArray.length);
    }

    //Create a heap from just a capacity. The heap is entirely empty to begin with.
    public HeapPriorityQueue(int requestedCapacity)
    {
        this((E[])(new Comparable[0]), requestedCapacity);
    }

    //Build a heap from the middle of the array down to the first element.
    private void buildHeap(E[] heap)
    {
        for (int i = size / 2; i >= 1; i--)
        {
            heapify(heap, i);
        }
    }

    //Recursively percolate the element at index down.
    private void heapify(E[] heap, int index)
    {
        int smallest;
        if (2*index <= size && heap[2*index].compareTo(heap[index]) < 0)
            smallest = 2*index;
        else
            smallest = index;

        if (2*index + 1 <= size && heap[(2*index)+1].compareTo(heap[smallest]) < 0)
            smallest = 2*index + 1;

        if (smallest != index)
        {
            E temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            heapify(heap, smallest);
        }
    }

    //Return the minimum element.
    public E min() 
    {
        if (!isEmpty())
            return heap[1];   
        else   
        {
            throw new EmptyHeapException();
        } 
    }

    //Delete the minimum element and return it. 
    public E deleteMin() 
    {
        if (!isEmpty())
        {
            //Store the minimum element to return it later.
            E tempMin = heap[1];
            
            //Replace the first spot with the last element.
            heap[1] = heap[size];
            heap[size] = null;
            size--;

            //Percolate the element at index one down. Restores Heap Property.
            heapify(heap, 1);

            return tempMin;
        }
        else
        {
            throw new EmptyHeapException();
        }
    }

    //Insert an element on the end of the heap. Percolate the element up to restore heap property.
    public boolean insert(E data) 
    {
        if (!isFull() && data != null)
        {
            //Expand size and append the new element.
            size++;
            heap[size] = data;
            int i = size;
            
            //Percolate the new element up. 
            while (i > 1 && heap[i].compareTo(heap[i/2]) < 1)
            {
                //Three step swap to send the element up one layer.
                E temp = heap[i];
                heap[i] = heap[i/2];
                heap[i/2] = temp;

                i /= 2;
            }

            return true;
        }
        else if(isFull())
        {
            throw new FullHeapException();
        }
        else if(data == null)
        {
            throw new NullElementException();
        }
        else   
        {
            return false;
        }
    }

    //Check if the heap is empty.
    public boolean isEmpty()
    {
        if (size < 1)
            return true;
        return false;
    }

    //Check if the heap is full.
    public boolean isFull()
    {
        if (size >= capacity)
            return true;
        return false;
    }

    //Get the size of the heap. Equal to the amount of non Null cells in the heap.
    public int size()
    {
        return size;
    }
}