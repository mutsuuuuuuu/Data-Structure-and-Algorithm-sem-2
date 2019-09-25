import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIO
{
	public static void main(String [] args)
	{
		DSAHashTable table=new DSAHashTable(4);
		//read the file
		FileInputStream fstream = null;
		InputStreamReader inputStreamReader;
		BufferedReader bufferedReader;
		String line;
		int count;
		try
		{
			fstream = new FileInputStream("testIO.csv");
			inputStreamReader = new InputStreamReader(fstream);
			bufferedReader = new BufferedReader(inputStreamReader);

			count = 0;
			line = bufferedReader.readLine();
			table = processLine(line,table);
			count++;
			while(line != null)
			{
				line = bufferedReader.readLine();
				table = processLine(line,table);
				count++;
			}
			System.out.println("Hash Table total: ");
			System.out.println(table.toString());

			System.out.print("Hash Table Load Factor: ");
			System.out.println(table.getLoadFactor());

			System.out.print("Element count in hash table: ");
			System.out.println(table.getCount());


			fstream.close();
		}
		catch (IOException ex)
		{
			if (fstream !=null)
			{
				try
				{
					fstream.close();
				}
				catch (IOException ex2)
				{

				}
			}
		}
	}

	private static DSAHashTable processLine(String line,DSAHashTable table)
	{
		if (line !=null)
		{
			String[] splits = line.split(",");
			//splits[0] is student id
			//splits[1] is student name
			table.put(splits[0], splits[1]); // the key is student id
		}

		return table;
	}

}
