package p02;

import java.util.Arrays;

public abstract class Queue
{
    Object [] Queue;

    public static final int MAX_CAPACITY = 100;

    public Queue()
    {
        Queue = new Object[MAX_CAPACITY];
    }
    public Queue(int capacity)
    {
        Queue = new Object[capacity];
    }

    public abstract int getCount();

    public abstract boolean isEmpty();

    public abstract boolean isFull();

    public abstract void enqueue(Object value);

    public abstract Object dequeue();

    public abstract Object peek();

    public abstract String toString();

}
