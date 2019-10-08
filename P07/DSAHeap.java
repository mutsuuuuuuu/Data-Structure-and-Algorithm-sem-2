import java.util.Arrays;
public class DSAHeap {

    private static final double UPPER_BOUND = 0.70;
    private static final double LOWER_BOUND = 0.40;
    private DSAHeapEntry[] heapEntry;
    private int count;

    //make the constructor

    public DSAHeap(int maxHeap)
    {
        int actualSize=findNextPrime(maxHeap);
        heapEntry = new DSAHeapEntry[actualSize];
        count = 0;
    }

    public void add(int priority, Object value)
    {
        DSAHeapEntry entry = new DSAHeapEntry(priority,value);
        if (count == 0)
        {
            heapEntry[count]= entry;
            count++;
        }
        else
        {
            if (getNextLoadFactor() <= UPPER_BOUND)
            {
                heapEntry[count] = entry;
                heapEntry=recusiveTrickleUp(heapEntry,count);
            }
            else
            {
                resize(2*heapEntry.length);
                heapEntry[count] = entry;
                heapEntry=recusiveTrickleUp(heapEntry, count);
            }
            count++;
        }

    }


    public void remove(int priority)
    {
        if (count ==0)
        {
            throw new IllegalArgumentException("Heap array is empty.");
        }
        else
        {
            for (int x = 0; x < count; x++)
            {
                if (heapEntry[x].getPriority()==priority)
                {
                    heapEntry[x] = heapEntry[count-1];
                    heapEntry[count-1]=null;
                    count--;
                    recursiveTrickleDown(heapEntry,x,count);
                }
            }

        }

    }


    public DSAHeapEntry [] heapSort()
    {
        for (int ii = count-1; ii>0; ii--)
        {
            heapEntry = swap(heapEntry,0,ii);
            recursiveTrickleDown(heapEntry,0,ii);
        }

        return heapEntry;
    }

    private DSAHeapEntry [] heapify(DSAHeapEntry [] heapEntry, int numItems)
    {
        for(int ii=((numItems/2)-1); ii>=0; ii--)
        {
            recursiveTrickleDown(heapEntry,ii,numItems);
        }

        return heapEntry;
    }

    private DSAHeapEntry[] swap(DSAHeapEntry [] array, int number, int number2)
    {
        DSAHeapEntry temp = array[number2];
        array[number2]=array[number];
        array[number]=temp;

        return array;
    }

    public int getNumItems()
    {
        return this.count;
    }

    private DSAHeapEntry[] resize(int newSize)
    {
        int nextPrime=findNextPrime(newSize);
        heapEntry=Arrays.copyOf(heapEntry,nextPrime);

        return heapEntry;
    }
    private double getNextLoadFactor()
    {
        return (count+1)/heapEntry.length;
    }

    private DSAHeapEntry [] recursiveTrickleDown(DSAHeapEntry [] heapArray, int currentIndex, int Numitems)
    {
        int leftchild = getLeftChildIndex(currentIndex);
        int rightchild = getRightChildIndex(currentIndex);
        int largeindex=0;
        if (leftchild < Numitems)
        {
            largeindex = leftchild;
            if (rightchild < Numitems)
            {
                if (heapArray[leftchild].getPriority() < heapArray[rightchild].getPriority())
                {
                    largeindex = rightchild;
                }
            }
            if (heapArray[largeindex].getPriority() > heapArray[currentIndex].getPriority())
            {
                DSAHeapEntry temp = heapArray[currentIndex];
                heapArray[currentIndex] = heapArray[largeindex];
                heapArray[largeindex] = temp;
                recursiveTrickleDown(heapArray, largeindex, Numitems);

            }
        }
            return heapArray;
    }

    private DSAHeapEntry [] recusiveTrickleUp(DSAHeapEntry [] heapArray, int currentIndex)
    {
        int parentIndex = getParentIndex(currentIndex);
        if (currentIndex > 0)
        {
            if (heapArray[currentIndex].getPriority() > heapArray[parentIndex].getPriority())
            {
                DSAHeapEntry temp = heapArray[parentIndex];
                heapArray[parentIndex] = heapArray[currentIndex];
                heapArray[currentIndex] = temp;
                recusiveTrickleUp(heapArray,parentIndex);
            }
        }

        return heapArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(heapEntry);
    }

    private int findNextPrime(int startVal)
    {
        int prime;
        int ii;
        if(startVal % 2 == 0)
        {
            prime = startVal - 1;
        }
        else
        {
            prime = startVal;
        }

        boolean isPrime = false;
        do
        {
            prime = prime + 2;
            ii = 3;
            isPrime = true;
            double rootVal = Math.sqrt(prime);
            do
            {
                if(prime % ii == 0)
                {
                    isPrime = false;
                }
                else
                {
                    ii += 2;
                }
            }
            while(ii <= rootVal && isPrime);
        }
        while(!isPrime);
        return prime;
    }

    private int getLeftChildIndex(int currentIndex)
    {
        return (currentIndex*2)+1;
    }

    private int getRightChildIndex(int currentIndex)
    {
        return (currentIndex*2)+2;
    }

    private int getParentIndex(int currentIndex)
    {
        return (currentIndex-1)/2;
    }

}
