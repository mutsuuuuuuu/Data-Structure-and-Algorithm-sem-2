package p02;

import java.util.Arrays;

public class BasicQueue extends Queue
{
    int count, lowCount;
    public BasicQueue()
    {
        super();
        count = 0;
        lowCount = 0;
    }

    public BasicQueue(int capacity)
    {
        super();
        count = 0;
        lowCount = 0;
    }

    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        boolean isEmpty  = false;
        if (count == 0)
        {
            isEmpty = true;
        }

        return isEmpty;
    }

    public boolean isFull()
    {
        boolean isFull = false;
        if (count == MAX_CAPACITY)
        {
            isFull = true;
        }
        return isFull;
    }

    @Override
    public void enqueue(Object value)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("p02.Queue is full");
        }
        else
        {
            Queue[this.count] = value;
            this.count++;
        }
    }

    @Override
    public Object dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("p02.Queue is empty");
        }
        else
        {
            Queue[this.lowCount] = null;
            this.count--;
            this.lowCount++;
        }
        return Queue;
    }

    @Override
    public Object peek()
    {
        return Queue[lowCount];
    }

    public String toString()
    {
        return Arrays.toString(Queue);
    }


}
