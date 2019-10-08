import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest
{
    public static void main(String [] args)
    {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;


        DSAHeap entry = new DSAHeap(10);


        String line = null;
        String [] splits;
        int count;
        try {
            fileInputStream = new FileInputStream("heapTest.csv");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            count = 0;
            line=bufferedReader.readLine();
            splits = line.split(",");
            entry.add(Integer.parseInt(splits[0]),splits[1]);
            count++;
            while (line != null)
            {
                line = bufferedReader.readLine();
                count++;
                if (line != null)
                {
                    splits = line.split(",");
                    entry.add(Integer.parseInt(splits[0]), splits[1]);
                }

            }
            fileInputStream.close();
        }
        catch (IOException ex)
        {
            if (fileInputStream!=null)
            {
                try
                {
                    fileInputStream.close();

                }
                catch (IOException ex2)
                {

                }
            }
        }

        System.out.println("Heap Before Sorting");
        System.out.println(entry.toString());
        System.out.println("Heap After Sorting");
        entry.heapSort();
        System.out.println(entry.toString());

    }
}
