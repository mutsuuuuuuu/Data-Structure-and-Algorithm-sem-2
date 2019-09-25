import java.time.Duration;
import java.time.Instant;

public class HashTable
{
    public static void main (String [] args)
    {
        DSAHashTable hashTest = new DSAHashTable(3);

        hashTest.put("R",1);
        hashTest.put("Ra",32);
        hashTest.put("Ran",54);
        hashTest.put("Rand",51);
        hashTest.put("Rando",12);

        System.out.println("Get value of Ra: " +hashTest.get("Ra"));

        System.out.println(hashTest.toString());
        System.out.println("Load factor at this point : " +hashTest.getLoadFactor() + "");

        hashTest.remove("Ra");
        System.out.println(hashTest.toString());
        System.out.println("Load factor at this point : " +hashTest.getLoadFactor());

    }
}
