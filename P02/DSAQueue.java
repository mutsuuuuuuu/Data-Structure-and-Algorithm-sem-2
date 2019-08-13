package p02;

import java.util.Arrays;

public class DSAQueue
{
    Object[] Queue;
    int count;
    int lowestCount;

    public static final int DEFAULT_CAPACITY = 100;

    public DSAQueue() {
        Queue = new Object[DEFAULT_CAPACITY];
        count = 0;
        lowestCount = 0;
    }

    public DSAQueue(int capacity) {
        Queue = new Object[capacity];
        count = 0;
        lowestCount = 0;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        if (count == 0) {
            isEmpty = true;
        }

        return isEmpty;
    }

    public boolean isFull() {
        boolean isFull = false;
        if (count == Queue.length) {
            isFull = true;
        }

        return isFull;
    }

    public void enqueue(Object value)
    {
        if(isFull())
        {
            throw new IllegalArgumentException("p02.Queue is full");
        }
        else
        {
            this.Queue[this.count] = value;
            this.count++;
        }
    }

    public Object dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("p02.Queue is empty");
        }
        else
        {
            Queue[lowestCount]=null;
            count--;
            lowestCount++;

        }

        return Queue[lowestCount];
    }

    public Object peek()
    {
        Object frontVal = Queue[lowestCount];
        return frontVal;
    }

    public String toString()
    {
        return Arrays.toString(Queue);
    }
}
