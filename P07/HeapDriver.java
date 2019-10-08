import java.util.Random;

public class HeapDriver
{
    public static void main (String [] args)
    {
        DSAHeap heapTest = new DSAHeap(2);
        heapTest.add(50,31);
        heapTest.add(30,1);
        heapTest.add(34,3);
        heapTest.add(60,7);
        heapTest.add(100,4);

        System.out.println(heapTest.toString());

        heapTest.remove(100);

        System.out.println(heapTest.toString());

        heapTest.heapSort();

        System.out.println(heapTest.toString());

    }
}
