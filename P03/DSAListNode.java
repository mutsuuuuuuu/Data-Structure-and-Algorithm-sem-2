package p03;

import java.io.Serializable;

public class DSAListNode implements Serializable
{
    Object value;
    DSAListNode next;
    DSAListNode prev;

    public DSAListNode(Object inValue)
    {
        this.value = inValue;
        next = null;
        prev = null;
    }
    public Object getValue()
    {
        return value;
    }
    public DSAListNode getNext()
    {
        return next;
    }
    public void setNext(DSAListNode newNext)
    {
        next = newNext;
    }

    public DSAListNode getPrev()
    {
        return prev;
    }

    public void setPrev(DSAListNode newPrev)
    {
        prev = newPrev;
    }
}
