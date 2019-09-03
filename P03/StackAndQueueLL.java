package p03;

import java.io.*;
import java.util.Iterator;

public class StackAndQueueLL
{
    private static final String FILENAME_STACK = "output_STACK.txt";
    private static final String FILENAME_QUEUE = "output_QUEUE.txt";
    public static void main(String [] args)
    {
        System.out.println("TEST: LINKED LIST USING STACK AND QUEUE");
        try
        {
        LinkedListStack llstack = new LinkedListStack();
        LinkedListQueue llqueue = new LinkedListQueue();

        FileOutputStream outputStreamStack = new FileOutputStream(FILENAME_STACK);
        ObjectOutputStream ObjectStack = new ObjectOutputStream(outputStreamStack);

        FileOutputStream outputStreamQueue = new FileOutputStream(FILENAME_QUEUE);
        ObjectOutputStream ObjectQueue = new ObjectOutputStream(outputStreamQueue);

        testStackLinkedList(ObjectStack,llstack);
        outputStreamStack.close();


        testQueueLinkedList(ObjectQueue,llqueue);
        outputStreamQueue.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static void testStackLinkedList(ObjectOutputStream ObjectStack, LinkedListStack llstack)
    {
        System.out.println("USING STACK");
        System.out.println("==============================================");
        System.out.println("ADDING 5 ELEMENTS: AAA, BBB, CCC, DDD, EEE");
        System.out.println("==============================================");
        llstack.push("AAA");
        llstack.push("BBB");
        llstack.push("CCC");
        llstack.push("DDD");
        llstack.push("EEE");

        System.out.println("USING STACK");
        System.out.println("==============================================");
        System.out.println("ADDING 5 ELEMENTS: AAA, BBB, CCC, DDD, EEE");
        System.out.println("==============================================");
        llstack.push("AAA");
        llstack.push("BBB");
        llstack.push("CCC");
        llstack.push("DDD");
        llstack.push("EEE");

        System.out.println("USING STACK ITERATOR TO PRINT ALL ELEMENTS");
        System.out.println("LINKED LIST ELEMENT: ");
        Iterator iterator = llstack.iterator();
        while (iterator.hasNext() == true)
        {
            System.out.print(iterator.next()+ " ");
            System.out.println();
        }

        llstack.pop();
        System.out.println("REMOVING ONE ELEMENT FROM THE LINKED LIST");
        System.out.println("==============================================");
        System.out.print("THE TOP ELEMENT SHOULD BE DDD \n");
        System.out.println("TOP ELEMENT OF LINKED LIST: " +llstack.peek()+" ");

        System.out.println("==============================================");
        System.out.println("DESERIALIZATION OBJECT. OUTPUT FILE NAME: output_STACK");
        try
        {
            ObjectStack.writeObject(llstack);
            ObjectStack.close();
        }
        catch (IOException ex)
        {
            System.out.println("hi");
        }

    }

    public static void testQueueLinkedList(ObjectOutputStream ObjectQueue, LinkedListQueue llqueue)
    {
        System.out.println(" ");
        System.out.println("==============================================");
        System.out.println("USING QUEUE");
        System.out.println("==============================================");
        System.out.println("ADDING 5 ELEMENTS: AAA, BBB, CCC, DDD, EEE");
        System.out.println("==============================================");
        llqueue.enqueue("AAA");
        llqueue.enqueue("BBB");
        llqueue.enqueue("CCC");
        llqueue.enqueue("DDD");
        llqueue.enqueue("EEE");

        System.out.println("USING STACK ITERATOR TO PRINT ALL ELEMENTS");
        System.out.println("LINKED LIST ELEMENT: ");
        Iterator iterator = llqueue.iterator();
        while (iterator.hasNext() == true)
        {
            System.out.print(iterator.next()+ " ");
            System.out.println();
        }

        System.out.println("REMOVING ONE ELEMENT FROM THE LINKED LIST");
        llqueue.dequeue();

        System.out.print("THE TOP ELEMENT SHOULD BE BBB \n");
        System.out.println("TOP ELEMENT OF LINKED LIST: " +llqueue.top()+" ");

        System.out.println("==============================================");
        System.out.println("DESERIALIZATION OBJECT. OUTPUT FILE NAME: output_QUEUE");
        try
        {
            ObjectQueue.writeObject(llqueue);
            ObjectQueue.close();
        }
        catch (IOException ex)
        {
            System.out.println("hi");
        }


    }
}
