import java.lang.*;
import java.util.Arrays;

public class DSAHashTable
{


    private DSAHashEntry [] hashArray;
    private int count;


    private static final double UPPER_BOUND = 0.70;
    private static final double LOWER_BOUND = 0.40;

    public DSAHashTable(int tableSize)
    {
        int actualSize = findNextPrime(tableSize);
        hashArray = new DSAHashEntry[actualSize];
        for(int ii = 0; ii < actualSize; ii++)
        {
            DSAHashEntry entry = new DSAHashEntry();
            hashArray[ii] = entry;
        }
    }
    public void put(String inKey,Object inValue)
    {
        //get the hashFunction
       int hashIndex = hashFunction(inKey);

       DSAHashEntry obj = new DSAHashEntry(inKey,inValue);
       if (checkNextLoadFactor() <= UPPER_BOUND)
       {
           insert(obj,hashIndex);
           count+=1;
       }
       else
       {
           //resize it
           resize(2*hashArray.length,"L");
           insert(obj,hashIndex);
           count+=1;
       }

    }

    private void insert(DSAHashEntry obj, int hashIndex)
    {
        int originalIndex = hashIndex;
        if (hashArray[hashIndex].getState() == 0 || hashArray[hashIndex].getState() == -1)
        {
            hashArray[hashIndex] = obj;
        }
        else
        {
            boolean giveUp = false;
            hashIndex = (hashIndex + 1) % hashArray.length;
            while (!giveUp)
            {
                if (hashArray[hashIndex].getState() == 0 || hashArray[hashIndex].getState() == -1)
                {
                    hashArray[hashIndex] = obj;
                    giveUp = true;
                }
                else
                {
                    if (hashIndex == originalIndex)
                    {
                        giveUp = true;
                    }
                }
                hashIndex = (hashIndex + 1) % hashArray.length;
            }
        }
    }

    private int hashFunction(String inKey)
    {
        int hashIndex = 0;
        for (int ii = 0; ii<inKey.length(); ii++)
        {
            hashIndex = (31*hashIndex + inKey.charAt(ii)) % hashArray.length;
        }
    return hashIndex % hashArray.length;
    }   
    
    public Object get(String inKey)
    {
        int hashIndex = hashFunction(inKey);
        int OriginalIndex = hashIndex;
        boolean found = false;
        boolean giveUp = false;
        Object value = null;

        while (!found && !giveUp)
        {
            if (hashArray[hashIndex].getState()==0)
            {
                giveUp =  true;
            }
            else if (hashArray[hashIndex].getKey() == inKey)
            {
                found =  true;
                value = hashArray[hashIndex].getValue();
            }
            else
            {
                hashIndex = (hashIndex + 1) % hashArray.length;
                if (hashIndex == OriginalIndex)
                {
                    giveUp = true;
                }
            }
        }

        if (!found)
        {
            throw new IllegalArgumentException("Not found");
        }

        return value;

    }
    
    public void remove(String inKey)
    {
        int key = hashFunction(inKey);
        int originalIndex = key;
        boolean found = false;
        boolean giveUp = false;

        while(!found && !giveUp)
        {
            if (hashArray[key].getState() == 0)
            {
                giveUp = true;
            }
            else if (hashArray[key].getKey() == inKey)
            {
                found = true;
                hashArray[key] = new DSAHashEntry();
                hashArray[key].setState(-1);
                count--;
                if(getLoadFactor()<= LOWER_BOUND)
                {
                    resize(hashArray.length-2,"D");
                }
            }
            else
            {
                key = (key + 1) % hashArray.length;
                if (key == originalIndex)
                {
                    giveUp = true;
                }
            }
        }
        if (!found)
        {

        }
    }

    public int getCount()
    {
        return count;
    }

    public double getLoadFactor()
    {
        double lf;
        double al = hashArray.length;
        lf = ((double)count/al);

        return lf;
    }

    private float checkNextLoadFactor()
    {
        float loadFactor;
        loadFactor = (count+1)/hashArray.length;

        return loadFactor;
    }
    
    private void resize(int Size,String type)
    {
        type = type.toUpperCase();
        DSAHashEntry[] temp = hashArray;
        switch (type)
        {
            case "L":
                int nextPrime = findNextPrime(Size);
                hashArray = new DSAHashEntry[nextPrime];
                for (int ii = 0; ii < nextPrime; ii++)
                {
                    if (hashArray[ii] == null)
                    {
                        hashArray[ii] = new DSAHashEntry();
                    }
                }
                reHashing(temp);
            break;
            case "D":
                hashArray = new DSAHashEntry[Size];
                for (int jj =  0;jj<hashArray.length;jj++)
                {
                    if (hashArray[jj]==null)
                    {
                        hashArray[jj]= new DSAHashEntry();
                    }
                }
                reHashing(temp);
                break;

        }
    }
    private void reHashing(DSAHashEntry[] temp)
    {
        for (int i = 0; i<temp.length; i++)
        {
            String inkey = temp[i].getKey();
            Object inObject = temp[i].getValue();

            int hash = hashFunction(inkey);
            DSAHashEntry entry = new DSAHashEntry(inkey,inObject);
            insert(entry,hash);
        }
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

    public String toString()
    {
        return Arrays.toString(hashArray);
    }

}
