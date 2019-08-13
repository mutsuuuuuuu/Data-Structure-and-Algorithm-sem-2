//  NAME : DICKY LARSON GULTOM
//  STUDENT ID : 19487537

import java.io.*;
import java.util.Scanner;

public class dsa_wk01
{


    public static void main (String [] args)
    {
        int menu,arraySize;
        String Filename;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file\n");
        Filename = sc.nextLine();

        //making the array of size n.
        arraySize = countLine(Filename);
        System.out.println("Creating array with "+arraySize );
        student [] studentData = new student[arraySize];

        System.out.println("Sorting " +arraySize+ " data");
        System.out.println("Choose the sorting method\n" +
                "1. Bubble Sort\n" +
                "2. Insertion Sort\n" +
                "3. Selection Sort\n ");
        menu = sc.nextInt();

        switch (menu)
        {
            case 1:
                studentData = readFile(Filename,studentData); //unsorted studentData array
                studentData = bubbleSort(studentData); // sorted studentData array
                fileWriter(studentData);
                break;
            case 2:
                studentData = readFile(Filename,studentData);
                studentData = insertionSort(studentData);
                fileWriter(studentData);
                break;

            case 3:
                studentData = readFile(Filename,studentData);
                studentData = selectionSort(studentData);
                fileWriter(studentData);
                break;
        }
    }

    private static student [] bubbleSort(student [] students)
    {
        int pass;
        boolean sorted;
        Object temp;
        pass = 0;
        do
            {
                sorted = true;

                for (int i = 0; i < (students.length - 1 - pass); i++)
                {
                    if (students[i].getStudentID() > students[i+1].getStudentID())
                    {
                        temp=students[i];
                        students[i] = students[i+1];
                        students[i+1] = (student) temp;
                        sorted = false;
                    }
                }
                pass =+ 1;
            }
        while (sorted == false);
        System.out.println("Bubble sort is done");

        return students;

    }

    private static student [] insertionSort(student [] students)
    {
        int ii;
        for(int x = 1; x < (students.length - 1); x++)
        {
            ii = x;
            while (ii > 0 && (students[ii-1].getStudentID() > students[ii].getStudentID()))
            {
                student temp = students[ii];
                students[ii] = students[ii-1];
                students[ii-1] = temp;

                ii -= 1;
            }

        }
        System.out.println("Insertion sort is done");
        return students;

    }

    private static student [] selectionSort(student [] students)
    {
        int minIndex;

        for (int nn = 0; nn < (students.length - 1); nn++)
        {
            minIndex = nn;
            for (int jj = nn + 1; jj < (students.length-1); jj++)
            {
                if (students[jj].getStudentID() < students[minIndex].getStudentID())
                {
                    minIndex = jj;
                }
            }

            student temp = students[minIndex];
            students[minIndex] = students[nn];
            students[nn] = temp;
        }
        System.out.println("selection sort is done");

        return students;
    }

    private static int countLine(String Filename)
    {
        int countLine=0;
        try
        {

            BufferedReader Buffreader = new BufferedReader(new InputStreamReader(new FileInputStream(Filename+".csv")));

            countLine = 0;
            while (Buffreader.readLine() != null)
            {
                countLine++;
            }
            Buffreader.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        return countLine;
    }

    private static student [] readFile(String Filename, student [] studentData)
    {

        FileInputStream stream = null;
        InputStreamReader input;
        BufferedReader buffRdr;

        int lineCount=0;
        String line;

        try
        {
            stream = new FileInputStream(Filename+".csv");
            input = new InputStreamReader(stream);
            buffRdr = new BufferedReader(input);

            line = buffRdr.readLine();
            parsingLine(line, lineCount, studentData);
            lineCount++;
            while(line != null)
            {
                line = buffRdr.readLine();
                parsingLine(line, lineCount, studentData);
                lineCount++;
            }
            stream.close();
        }
        catch (IOException e)
        {
            if (stream != null)
            {
                try
                {
                    stream.close();
                }
                catch (IOException ex2)
                {

                }
            }
            System.out.println("Error in file processing : " +e.getMessage());
        }

        System.out.print("Successfully reading the file\n");

        return studentData;
    }

    private static student [] parsingLine(String readLine, int lineCount, student [] studentData)
    {
        String line = readLine;
        long ID;
        String name;

        try {

            String[] tokens = line.split(",");
            ID = Long.parseLong(tokens[0]);
            name = tokens[1];

            studentData[lineCount] = new student(ID, name);
        }
        catch (NullPointerException ex)
        {
            ex.getCause();
        }
        return studentData;
    }

    private static void fileWriter(student [] data)
    {
        FileOutputStream stream=null;
        PrintWriter writer;

        try
        {
            stream = new FileOutputStream("output.txt");
            writer = new PrintWriter(stream);

            for (int x=0; x<data.length; x++)
            {
                writer.print(data[x].toString());
            }

            writer.close();

        }
        catch (IOException ex)
        {
            if (stream != null)
            {
                try
                {
                    stream.close();
                }
                catch (IOException ex2)
                {

                }

            }
            System.out.println("Error in writing file");

        }

    }
}
