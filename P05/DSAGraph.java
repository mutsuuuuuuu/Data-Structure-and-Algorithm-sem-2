

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class DSAGraph implements Serializable
{
    DSALinkedList vertices;
    int edgecount;
    int vertexcount;


    public DSAGraph()
    {
        this.vertices = new DSALinkedList();
        this.edgecount = 0;
        this.vertexcount = 0;
    }

    public void addVertex(String label)
    {
        DSAGraphNode vertex = new DSAGraphNode(label);
        if (!vertexExist(vertex))
        {
            addnewVertex(vertex);
            vertexcount++;
        }
    }

    public void addnewVertex(DSAGraphNode vertex)
    {
        vertices.insertLast(vertex);
    }

    public boolean vertexExist(DSAGraphNode vertex)
    {
        boolean exist = false;
        Iterator<DSAGraphNode> iterator = vertices.iterator();
        while(iterator.hasNext())
        {
            if (iterator.next().equals(vertex))
            {
                exist=true;
            }
        }
        return exist;
    }

    public void addEdge(String label1, String label2)
    {
        //checking if the node exist
        DSAGraphNode lab1 = getVertex(label1);
        DSAGraphNode lab2 = getVertex(label2);
        if (lab1 == null)
        {
            System.out.println("Creating a new vertex : " +label1);
            addVertex(label1);
        }
        if (lab2 == null)
        {
            System.out.println("Creating a new vertex : " +label2);
            addVertex(label2);
        }


        //now the two nodes exist
        DSAGraphNode fromNode = getVertex(label1);
        DSAGraphNode toNode = getVertex(label2);
        fromNode.addEdge(toNode);
        System.out.println("Added vertex " +label1 +" to " +label2);
        toNode.addEdge(fromNode);
        System.out.println("Added vertex " +label2 +" to " +label1);

        edgecount++;

    }


    public int getVertexCount()
    {
        return vertexcount;
    }

    public int getEdgeCount()
    {
        return edgecount;
    }

    public DSAGraphNode getVertex(String label)
    {
        Iterator<DSAGraphNode> iter= vertices.iterator();
        DSAGraphNode nodes = null;
        while(iter.hasNext())
        {
            DSAGraphNode node = iter.next();
            if (label.equals(node.getLabel()))
            {
                nodes = node;
            }
        }

        return nodes;

    }

    public DSALinkedList getAdjacent(String label)
    {
        DSALinkedList adjacent = null;
        Iterator<DSAGraphNode> dsaGraphNodeIterator = getVertex(label).getAdjacent().iterator();
        while(dsaGraphNodeIterator.hasNext())
        {
            if (dsaGraphNodeIterator.next().equals(getVertex(label)))
            {
                adjacent = getVertex(label).getAdjacent();
            }

        }
        return adjacent;

    }

    public boolean isAdjacent(String label1, String label2)
    {
        boolean adjacent = false;
        Iterator<DSAGraphNode> dsaGraphNodeIterator = getVertex(label1).getAdjacent().iterator();
        while(dsaGraphNodeIterator.hasNext())
        {
            if (dsaGraphNodeIterator.next() == getVertex(label2))
            {
                adjacent = true;
            }
        }
        return adjacent;

    }

    public void displayAsList()
    {
        System.out.println("Displaying as List");
        Iterator<DSAGraphNode> iterator = vertices.iterator();
        while (iterator.hasNext())
        {
            DSAGraphNode vertex = iterator.next();
            System.out.print(vertex.getLabel() + " | ");
            vertex.display();
        }
    }

    public void clearVisited()
    {
    }

    public void depthFirstSearch()
    {
        LinkedListStack stack = new LinkedListStack();
        //get the first node
        DSAGraphNode node = (DSAGraphNode)vertices.peekFirst();
        stack.push(node);
        node.setVisited();
        while (!stack.isEmpty())
        {
            DSAGraphNode v = (DSAGraphNode) stack.peek();
            System.out.print(v.getLabel()+ ", ");
            stack.pop();

            for (Object O : v.getAdjacent())
            {
                DSAGraphNode neighbour = (DSAGraphNode)O;
                if (neighbour.getVisited() == false)
                {
                    stack.push(neighbour);
                    neighbour.setVisited();
                }
            }
        }
        //clearing visited lmao
    }
}
