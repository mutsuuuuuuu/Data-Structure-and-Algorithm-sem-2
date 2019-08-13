package p02;

import java.util.Arrays;

public class CircularQueue extends Queue
{
    int front,rear;
    public CircularQueue()
    {
        super();
        front = 0;
        rear = -1;
    }

    public CircularQueue(int capacity)
    {
        super();
        front = 0;
        rear = -1;
    }

    public int getCount()
    {
        if(isEmpty())
        {
            return 0;
        }
        return rear + 1;
    }

    public int getFront()
    {
        return front;
    }

    public boolean isEmpty()
    {
        boolean isEmpty  = false;
        if (rear == -1)
        {
            isEmpty = true;
        }

        return isEmpty;
    }

    public boolean isFull()
    {
        boolean isFull = false;
        if (rear == MAX_CAPACITY)
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
            rear = rear +1;
            Queue[rear] = value;
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
            Queue[front] = null;
            front++;
        }
        return Queue;
    }

    @Override
    public Object peek()
    {
        return Queue[front];
    }
    public String toString()
    {
        return Arrays.toString(Queue);
    }
}
