import java.io.Serializable;
import java.util.Iterator;

public class LinkedListStack implements Iterable, Serializable
{

    private DSALinkedList List;

    public Iterator iterator()
    {
        return List.iterator();
    }

    public LinkedListStack ()
    {
        List = new DSALinkedList();
    }

    public boolean isEmpty()
    {
        boolean isEmpty = false;
        if(List.isEmpty() == true)
        {
            isEmpty = true;
        }
        return isEmpty;
    }

    public void push(Object value)
    {
        List.insertFirst(value);
    }

    public void pop()
    {
        if (List.peekFirst() != null)
        {
            List.removeFirst();
        }
        else
        {
            throw new IllegalArgumentException("Linked List is empty");
        }
    }

    public Object peek()
    {
        Object value;
        value = List.peekFirst();

        return value;
    }
}
