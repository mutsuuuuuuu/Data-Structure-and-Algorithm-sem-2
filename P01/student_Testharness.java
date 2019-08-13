/*
    NAME : DICKY LARSON GULTOM
    STUDENT ID : 19487537
*/
public class student_Testharness
{
    public static void main (String [] args)
    {
        student [] studentTest = new student[4];

        studentTest[0] = new student();
        studentTest[1] = new student(194867623,"No one");
        studentTest[2] = new student(194875337, "Myself");
        studentTest[3] = new student(14495655,"Sofia Bonfiglio");

        for (int i = 0; i<studentTest.length; i++)
        {
            System.out.print(studentTest[i].toString());
        }
    }
}
