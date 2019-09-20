import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIO
{

    public static void main(String [] args)
    {
        System.out.println("Example 1");
        example1();
        System.out.println("Example 2");
        example2();

    }

    public static void example1()
    {
        FileInputStream filestrm = null;
        InputStreamReader reader;
        BufferedReader bufferedReader;
        int lineNuml;
        String line;
        DSAGraph graph = new DSAGraph();
        try
        {
            filestrm = new FileInputStream("C:\\Users\\Dicky Gultom\\Documents\\DSA Sem 2\\src\\prac6_1.al");
            reader = new InputStreamReader(filestrm);
            bufferedReader = new BufferedReader(reader);

            lineNuml = 0;
            line = bufferedReader.readLine();
            graph = splitString(line, graph);
            lineNuml++;
            while (line != null)
            {
                line = bufferedReader.readLine();
                graph = splitString(line, graph);
                lineNuml++;

            }
            filestrm.close();
        }
        catch (IOException ex)
        {
            if (filestrm != null)
            {
                try
                {
                    filestrm.close();
                }
                catch (IOException ex1)
                {

                }
            }
            System.out.println("Error in file processing: " +ex.getMessage());
        }

        System.out.println("Get vertex count: " +graph.vertexcount);
        System.out.println("Get Edge Count: " +graph.getEdgeCount());

        graph.displayAsList();
        graph.displayAsMatrix();
        graph.depthFirstSearch();
        graph.breadthFirstSearch();
        System.out.println();
    }

    public static void example2()
    {
        FileInputStream filestrm = null;
        InputStreamReader reader;
        BufferedReader bufferedReader;
        int lineNuml;
        String line;
        DSAGraph graph = new DSAGraph();
        try
        {
            filestrm = new FileInputStream("C:\\Users\\Dicky Gultom\\Documents\\DSA Sem 2\\src\\prac6_2.al");
            reader = new InputStreamReader(filestrm);
            bufferedReader = new BufferedReader(reader);

            lineNuml = 0;
            line = bufferedReader.readLine();
            graph = splitString(line, graph);
            lineNuml++;
            while (line != null)
            {
                line = bufferedReader.readLine();
                graph = splitString(line, graph);
                lineNuml++;

            }
            filestrm.close();
        }
        catch (IOException ex)
        {
            if (filestrm != null)
            {
                try
                {
                    filestrm.close();
                }
                catch (IOException ex1)
                {

                }
            }
            System.out.println("Error in file processing: " +ex.getMessage());
        }

        System.out.println("Get vertex count: " +graph.vertexcount);
        System.out.println("Get Edge Count: " +graph.getEdgeCount());

        graph.displayAsList();
        graph.displayAsMatrix();
        graph.depthFirstSearch();
        graph.breadthFirstSearch();
        System.out.println();

    }

    public static DSAGraph splitString(String line, DSAGraph graph)
    {

        if (line != null)
        {
            String[] splits = line.split("\\s+");
            String fromNode = splits[0];
            String toNode = splits[1];

            graph.addEdge(fromNode, toNode);

        }

        return graph;
    }
}
