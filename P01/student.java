/*
    NAME : DICKY LARSON GULTOM
    STUDENT ID : 19487537
*/
public class student
{
    long studentID;
    String studentName;

    public student()
    {
        studentID = 9999999;
        studentName = "John Doe";
    }

    public student(long inStudentID, String inStudentName)
    {
        studentID = inStudentID;
        studentName = inStudentName;
    }

    public student(student inStudent)
    {
        studentID = inStudent.getStudentID();
        studentName = inStudent.getStudentName();
    }

    public void setStudentID(long studentID)
    {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public long getStudentID()
    {
        return studentID;
    }

    public String toString()
    {
        String toString = "Student ID: " +getStudentID() + " Student Name: " +getStudentName() +"\n";
        return toString;
    }

    public String getStudentName()
    {
        return studentName;
    }

}
