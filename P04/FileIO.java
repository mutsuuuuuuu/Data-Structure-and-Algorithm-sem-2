import java.io.*;
import java.util.Scanner;

public class FileIO extends BinarySearchTree
{
    private static final String FILE_NAME = "student.csv";
    public static void main (String [] args)
    {
        int menu;
        Scanner sc = new Scanner(System.in);
        //read the file
        BinarySearchTree bst = new BinarySearchTree();
        readFile(bst);

        //save the tree into the serialized file
        System.out.println("Saving the BST into a file called output.txt");
        saveTree(bst);

        //Tranversal menu
        System.out.println("Choose a traversal: \n" +
                "1: In Order\n" +
                "2: Pre Order\n" +
                "3: Post Order");
        menu = sc.nextInt();
        switch (menu)
        {
            case 1:
                System.out.println("In Order Traversal");
                bst.inOrderTranversal();
                break;

            case 2:
                System.out.println("Pre Order Traversal");
                bst.postOrderTranversal();
                break;

            case 3:
                System.out.println("Post Order Traversal");
                bst.postOrderTranversal();
                break;

            default:
        }
        
        //try to read the serialized file
        BinarySearchTree ex = new BinarySearchTree();
        ex = writeFile();
        System.out.println("Deserializing Object succesfully");
        try
        {
            ex.postOrderTranversal();
            ex.inOrderTranversal();
            ex.postOrderTranversal();
        }
        catch (NullPointerException fx)
        {

        }
    }
    private static BinarySearchTree writeFile() throws IllegalArgumentException
    {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        BinarySearchTree binarySearchTree = null;
        try
        {
            fileInputStream = new FileInputStream("output.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            binarySearchTree = (BinarySearchTree)objectInputStream.readObject();

            objectInputStream.close();

        }
        catch (IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
        catch (ClassNotFoundException EX)
        {
            System.out.println("Binary Search Tree not found " +EX.getMessage());
        }
        return binarySearchTree;
    }
    private static void saveTree(BinarySearchTree bst)
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            ObjectOutputStream object = new ObjectOutputStream(fileOutputStream);

            try
            {
                object.writeObject(bst);
                object.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getStackTrace());
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }
    private static BinarySearchTree readFile(BinarySearchTree bst)
    {
        FileInputStream fstream=null;
        InputStreamReader ireader;
        BufferedReader breader;

        int count;
        String line;
        try
        {
            fstream = new FileInputStream(FILE_NAME);
            ireader = new InputStreamReader(fstream);
            breader = new BufferedReader(ireader);
            
            count = 0;
            line = breader.readLine();
            parseString(line,bst);
            count++;
            while(line != null)
            {   
                line = breader.readLine();
                parseString(line,bst);
                count++;
            }
            fstream.close();
        }
        catch (IOException o)
        {
            if(fstream != null)
            {
                try
                {
                    fstream.close();
                }
                catch (IOException o2)
                {
                } 
            }  
        }

    return bst;
    }
    private static BinarySearchTree parseString(String line, BinarySearchTree bst)
    {
        try
        {
            String[] parsing = line.split(",");
            bst.insertNode(parsing[0],parsing[1]);
        }
        catch (NullPointerException ex)
        {
        }
        return bst;
    }
}
