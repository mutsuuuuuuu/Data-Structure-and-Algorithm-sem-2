package p03;

import java.util.Iterator;

public class LinkedListTest
{
    public static void main (String [] args)
    {
        System.out.println("ITERATOR LINKED LIST TEST");
        DSALinkedList ll = new DSALinkedList();

        System.out.println("ADDING FIVE ELEMENTS TO THE LINKED LIST: AAA, BBB, CCC, DDD, EEE");
        ll.insertFirst("AAA");
        ll.insertFirst("BBB");
        ll.insertFirst("CCC");
        ll.insertFirst("DDD");
        ll.insertFirst("EEE");

        Iterator iterator = ll.iterator();
        System.out.println("TESTING HASNEXT METHOD AND NEXT METHOD OF THE ITERATOR: ");
        System.out.println("====================================================================");
        System.out.println("LIST ELEMENTS IN LINKED LIST: ");
        while (iterator.hasNext())
        {
            System.out.print(iterator.next()+ " ");
            System.out.println();
        }
    }
}
