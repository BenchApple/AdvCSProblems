public class HeapPriorityQueue<E extends Comparable<? super E>> implelements PriorityQueue<E>
{
    private E[] heap;
    private int size;
    private int capacity;

    public HeapPriorityQueue(E[] userArray, int userCapacity)
    {
        capacity = userCapacity + 1;
        size = userHeap.length;

        heap = buildHeap(userArray);
    }

    private void buildHeap(E[] userArray)
    {
        for (int i = size / 2; i >= 1; i++)
        {
            heapify(i);
        }
    }

    private void heapify(E[] heap, int index)
    {
        int smallest;
        if (2*i <= heap.length && heap[2*1] < heap[i])
            smallest = 2*i;
        else
            smallest = i;

        if (2*i + 1 <= heap.length && heap[2*i+1] < heap[smallest])
            smallest = 2*i + 1;

        if (smallest != i)
        {
            E temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            heapify(heap, smallest);
        }
    }
}