package p02;

import java.util.Arrays;

public class DSAStack
{
    public static final int DEFAULT_CAPACITY = 100;
    Object [] Stack;
    int count;

    public DSAStack()
    {
        Stack = new Object[DEFAULT_CAPACITY];
        count=0;
    }
    public DSAStack(int maxCapacity)
    {
        Stack = new Object[maxCapacity];
        count=0;
    }

    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        boolean empty = false;
        if (count == 0)
        {
            empty = true;
        }
        return empty;
    }

    public boolean isFull()
    {
        boolean full = false;
        if (count == Stack.length)
        {
            full = true;
        }
        return full;
    }

    public void pushStack (Object value)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Stack is full");
        }
        else
        {
            Stack[count] = value;
            count = count + 1;
        }
    }

    public Object popStack()
    {
        count = count - 1;

        return Stack[count] = null;
    }

    public Object top()
    {
        Object topVal;
        if (isEmpty())
        {
            throw new IllegalArgumentException();
        }
        else
        {
            topVal = Stack[count-1];
        }

        return topVal;
    }

    public String toString()
    {
        return Arrays.toString(Stack);
    }
}
