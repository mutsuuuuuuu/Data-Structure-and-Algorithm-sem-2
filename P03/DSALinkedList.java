package p03;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DSALinkedList
        implements Iterable, Serializable
{
    DSAListNode head;
    DSAListNode tail;

    public Iterator iterator()
    {
        return new DSALinkedListIterator(this);
    }

    public DSALinkedList()
    {
        head=null;
        tail=null;
    }
    public void insertFirst(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        if (isEmpty())
        {
            //if its empty, head and tail node becomes the value of newNd.
            head = tail = newNd;
            head.setPrev(null);
            head.setNext(null);
        }
        else
        {
            //new node will point to the head (next)
            newNd.setNext(head);
            //head node will point to the head (prev)
            head.setPrev(newNd);
            //set the head value to new node
            head = newNd;
            //set the newhead previous point to null
            head.setPrev(null);
        }
    }

    public void insertLast(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        DSAListNode currNd;
        if (isEmpty())
        {
            //head and tail become the value of new node
            head = tail = newNd;
            //point the prev head value into null
            head.setPrev(null);
            //point the next head value into null
            head.setNext(null);
        }
        else
        {
            currNd = head;
            while (currNd.getNext() != null)
            {
                currNd = currNd.getNext();
            }
            //point the next tail value into newNode
            tail.setNext(newNd);
            //point the prev new node value into tail
            newNd.setPrev(tail);
            //make tail new node
            tail = newNd;
        }
    }

    public boolean isEmpty()
    {
        boolean isEmpty = false;
        if (head == null)
        {
            isEmpty = true;
        }

        return isEmpty;
    }
    public Object peekFirst()
    {
        Object nodeValue;
        if (isEmpty())
        {
            throw new NoSuchElementException("The linked list is empty");
        }
        else
        {
            nodeValue = head.getValue();
        }
        return nodeValue;
    }

    public Object peekLast()
    {
        Object nodeValue;
        if (isEmpty())
        {
            throw new NoSuchElementException("The linked list is empty");
        }
        else
        {
           nodeValue = tail.getValue();
        }
        return nodeValue;
    }

    public Object removeFirst()
    {
        Object nodeValue;
        if (isEmpty())
        {
           throw new NoSuchElementException("The linked list is empty");
        }
        else if (head.getNext() == null)
        {
            nodeValue = head.getValue();
            head = null;
        }
        else
        {
            //set node value into head value
            nodeValue = head.getValue();
            //set the head value into the next value
            head = head.getNext();
            //break the previous link .
            head.setPrev(null);

        }
        return nodeValue;
    }

    public Object removeLast()
    {
        Object nodeValue;
        if (isEmpty())
        {
            throw new IllegalArgumentException("Node is empty");
        }
        else if (tail.getNext() == null)
        {
            //set the node value into head value
            nodeValue = tail.getValue();
            //set the tail value into the previous value
            tail = tail.getPrev();
            //break the forward link
            tail.setNext(null);
        }
        else
        {
            DSAListNode prevNd, currNd;
            prevNd = null;
            currNd = head;
            while(currNd.getNext() != null)
            {
                prevNd = currNd;
                currNd = currNd.getNext();
            }
            tail = prevNd;
            prevNd.setNext(null);
            nodeValue = currNd.getValue();
        }
        return nodeValue;
    }

    private class DSALinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;
        public DSALinkedListIterator(DSALinkedList theList)
        {
            iterNext = theList.head;
        }
        public boolean hasNext()
        {
            return (iterNext!=null);
        }
        public Object next()
        {
            Object value;
            if (iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return  value;
        }
        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }

    }
}
