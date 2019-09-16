import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DSAGraphNode
{
    DSALinkedList links;
    boolean visited;
    String label;

    public DSAGraphNode(String inlabel)
    {
        this.label = inlabel;
        this.visited = false;
        this.links = new DSALinkedList();
    }

    public String getLabel()
    {
        return this.label;
    }

    public void setVisited()
    {
        this.visited = true;
    }

    public void clearVisited()
    {
        this.visited = false;
    }

    public boolean getVisited()
    {
        return this.visited;
    }

    public DSALinkedList getAdjacent()
    {
        return this.links;
    }

    public void addEdge(DSAGraphNode vertex)
    {
        if (!linkExist(vertex))
        {
            this.links.insertLast(vertex);
        }
    }

    public boolean linkExist(DSAGraphNode vertex)
    {
        boolean exist = false;
        Iterator <DSAGraphNode> iterator = links.iterator();
        while (iterator.hasNext())
        {
            DSAGraphNode node = iterator.next();
            if (node.getLabel().equals(vertex.getLabel()))
            {
                exist = true;
            }
        }
        return exist;
    }

    public void display()
    {
        Iterator<DSAGraphNode> iterator = links.iterator();
        while(iterator.hasNext())
        {
            DSAGraphNode vertexLink = iterator.next();
            System.out.print(vertexLink.getLabel());
            if (iterator.hasNext())
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }


}
