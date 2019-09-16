import java.io.Serializable;
import java.util.Iterator;

public class LinkedListQueue implements Iterable, Serializable
{
    private DSALinkedList LinkedList;

    public Iterator iterator()
    {
        return LinkedList.iterator();
    }

    public LinkedListQueue()
    {
        LinkedList = new DSALinkedList();
    }

    public boolean isEmpty()
    {
        boolean isEmpty = false;
        if (LinkedList.isEmpty() == true)
        {
            isEmpty = true;
        }
        return isEmpty;
    }
    public void enqueue(Object value)
    {
        LinkedList.insertLast(value);
    }
    public Object dequeue()
    {
        Object value;
        if (LinkedList.peekFirst() == null)
        {
            value = null;
        }
        value = LinkedList.peekFirst();
        LinkedList.removeFirst();
        return value;
    }
    public Object top()
    {
        Object value;
        if (LinkedList.peekFirst() == null)
        {
            value = null;
        }
        else
        {
            value = LinkedList.peekFirst();
        }
        return value;
    }

}
