package p02;

public class DSAQueue_testHarness
{
    public static void main(String [] args)
    {
        BasicQueue basic = new BasicQueue();
        CircularQueue circular = new CircularQueue();
        ShufflingQueue shuffling = new ShufflingQueue();


        testingBasicQueue(basic);
        testingShufflingQueue(shuffling);
        testingCircularQueue(circular);

    }
    private static void testingBasicQueue(BasicQueue basic)
    {
        System.out.println("Testing Basic p02.Queue");
        System.out.println("Printing out the queue: " +basic);
        System.out.println("Length should be zero : " +basic.getCount());
        System.out.println("And the isEmpty method should return true: " +basic.isEmpty());
        System.out.println("Adding 3 elements into the queue");
        basic.enqueue(3);
        basic.enqueue(4);
        basic.enqueue(1);
        System.out.println("Printing out the queue " +basic);
        System.out.println("Length should be 3 : " +basic.getCount());
        System.out.println("Testing deQueue : dequeue 2 elements");
        basic.dequeue();
        basic.dequeue();
        System.out.println("Printing out the queue " +basic);
        System.out.println("Length should be 1: " +basic.getCount());
        System.out.println("Testing top method: ");
        System.out.println("The top element is: " + basic.peek());
    }

    private static void testingShufflingQueue(ShufflingQueue shuffling)
    {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Testing Shuffling p02.Queue");
        System.out.println("Printing out the queue: " +shuffling);
        System.out.println("Length should be zero : " +shuffling.getCount());
        System.out.println("And the isEmpty should return true: " +shuffling.isEmpty());
        System.out.println("Adding 3 elements into the queue");
        shuffling.enqueue(2);
        shuffling.enqueue(1);
        shuffling.enqueue(34);
        System.out.println("Printing out the queue " +shuffling);
        System.out.println("Length should be 3 : " +shuffling.getCount());
        System.out.println("Testing deQueue : dequeue 2 elements");
        shuffling.dequeue();
        shuffling.dequeue();
        System.out.println("Printing out the queue " +shuffling);
        System.out.println("Length should be 1: " +shuffling.getCount());
        System.out.println("Testing top method: ");
        System.out.println("The top element is: " + shuffling.peek());
    }

    private static void testingCircularQueue(CircularQueue circular)
    {

        System.out.println("----------------------------------------------------------------");
        System.out.println("Testing Circular p02.Queue");
        System.out.println("Printing out the queue: " +circular);
        System.out.println("Length should be zero : " +circular.getCount());
        System.out.println("And the isEmpty should return true: " +circular.isEmpty());
        System.out.println("Adding 3 elements into the queue");
        circular.enqueue(2);
        circular.enqueue(1);
        circular.enqueue(34);
        System.out.println("Printing out the queue " +circular);
        System.out.println("The front value must be 0: " +circular.getFront());
        System.out.println("The rear value must be at 3: " +circular.getCount());
        System.out.println("Testing deQueue : dequeue 2 elements");
        circular.dequeue();
        circular.dequeue();
        System.out.println("Printing out the queue " +circular);
        System.out.println("The front value must be 2: " +circular.getFront());
        System.out.println("The rear value must stays at 3: " +circular.getCount());
        System.out.println("Testing top method: ");
        System.out.println("The top element is: " + circular.peek());


    }



}
