package p02;

import java.util.Arrays;

public class ShufflingQueue extends Queue
{
    int count;
    public ShufflingQueue()
    {
        super();
        count = 0;
    }

    public ShufflingQueue(int capacity)
    {
        super();
        count = 0;
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
            Queue[0] = null;
            for (int x = 1; x <= count; x++)
            {
                Queue[x-1] = Queue[x];
            }
            this.count--;
        }
        return Queue;
    }

    @Override
    public Object peek()
    {
        Object frontVal = Queue[0];
        return frontVal;
    }

    public String toString()
    {
        return Arrays.toString(Queue);
    }
}
