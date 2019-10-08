import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class IOtest
{
    public static void main(String [] args)
    {
        try {
            String line;
            File myfile = new File("heapTest.csv");
            Scanner sc = new Scanner(myfile);
            line = sc.nextLine();
            System.out.println(line);
            while (sc.hasNext())
            {
                line = sc.nextLine();
                System.out.println(line);
            }
        }
        catch (FileNotFoundException ex)
        {

        }
    }
}
