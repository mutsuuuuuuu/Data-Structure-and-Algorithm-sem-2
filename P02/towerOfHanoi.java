package p02;

public class towerOfHanoi
{
    public static void main (String [] args)
    {

        towerOFHanoi(3,1,3);

    }


    public static void towerOFHanoi(int pegs, int from_pegs, int destination_pegs)
    {
        int tower = pegs;
        int source = from_pegs;
        int dest = destination_pegs;
        int temp;
        if (pegs == 1)
        {
            System.out.println("Moving a disk from " +from_pegs+ " to " +destination_pegs);
        }
        else
        {
            temp = 6 - source - dest;
            towerOFHanoi(tower-1, source,temp);
            System.out.println("Moving a disk from " + source+ " to " +dest);
            towerOFHanoi(tower -1, temp, destination_pegs);
        }
    }

}
