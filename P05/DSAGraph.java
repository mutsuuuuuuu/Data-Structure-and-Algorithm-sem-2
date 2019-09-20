import com.sun.source.doctree.LiteralTree;

import java.io.Serializable;
import java.lang.reflect.Array;
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

    /**
     *
     * @param vertex
     */
    public void addnewVertex(DSAGraphNode vertex)
    {
        vertices.insertLast(vertex);
    }

    /**
     *
     * @param vertex
     * @return exist
     */

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

    /**
     *
     **@param label1
     * @param label2
     */

    public void addEdge(String label1, String label2)
    {
        //checking if the node exist
        DSAGraphNode lab1 = getVertex(label1);
        DSAGraphNode lab2 = getVertex(label2);
        if (lab1 == null)
        {
            addVertex(label1);
        }
        if (lab2 == null)
        {
            addVertex(label2);
        }


        //now the two nodes exist
        DSAGraphNode fromNode = getVertex(label1);
        DSAGraphNode toNode = getVertex(label2);
        fromNode.addEdge(toNode);
        toNode.addEdge(fromNode);

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

    /**
     *
     * @param label
     * @return nodes
     */

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

    /**
     *
     * @param label
     * @return adjacent
     */

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

    /**
     *
     * @param label1
     * @param label2
     * @return adjacent
     */

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

    public void displayAsMatrix()
    {
        System.out.println("Displaying as Matrix");
        int [][] adjacencyMatrix = new int[getVertexCount()][getVertexCount()];
        int i = 0;
        //set everything element in the matrix to zero
        adjacencyMatrix = allZero(adjacencyMatrix);
        Iterator<DSAGraphNode> iterator = vertices.iterator();
        while (i < adjacencyMatrix.length)
        {
            int j = 0;
            DSAGraphNode vertex = iterator.next();
            while (j<adjacencyMatrix[i].length)
            {
                for (Object comp : vertices)
                {
                    if (vertex.hasVertex((DSAGraphNode) comp))
                    {
                        adjacencyMatrix[i][j]=1;
                    }
                    j++;
                }
            }
            i++;
        }
        printMatrix(adjacencyMatrix);
    }

    public void printMatrix(int [][] matrix)
    {
        System.out.print("[ ");
        for (Object o: vertices)
        {
            DSAGraphNode obj = (DSAGraphNode)o;
            System.out.print(obj.getLabel() + " ");
        }
        System.out.print("]");
        System.out.println();
        for (int arr[] : matrix)
        {
            System.out.print("[ ");
            for (int val : arr)
            {
                System.out.print(+val + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public int [][] allZero(int [][] matrix)
    {
        for (int arr[] : matrix)
        {
            for (int val : arr)
            {
                val = 0;
            }
        }

        return matrix;
    }

    public void clearVisited()
    {
        DSAGraphNode node = null;
        for(Object o: vertices)
        {
            node = (DSAGraphNode)o;
            node.clearVisited();
        }
    }

    public void depthFirstSearch()
    {
        System.out.println("Depth First Search");
        LinkedListStack stack = new LinkedListStack();
        //get the first node as starting node
        DSAGraphNode node = (DSAGraphNode)vertices.peekFirst();
        //push it into the stack
        stack.push(node);
        //set the node as visited
        node.setVisited();
        //apply while loop
        while (!stack.isEmpty())
        {
            //get the top stack element
            DSAGraphNode v = (DSAGraphNode) stack.peek();
            //printout the label of the node
            System.out.print(v.getLabel()+ ", ");
            //pop it outta the stack
            stack.pop();

            //run for each loop
            //for each Adjacent Node Object (DSAGraphNode) in node v
            for (Object O : v.getAdjacent())
            {
                DSAGraphNode neighbour = (DSAGraphNode)O;
                if (neighbour.getVisited() == false) //checking if the node already visited if not push it and set the node to visited
                {
                    stack.push(neighbour);
                    neighbour.setVisited();
                }
            }
        }
        System.out.println();
        //BFS has finished, clear all visited node
        clearVisited();
    }

    public void breadthFirstSearch()
    {

        System.out.println("Breadth First Search");
        LinkedListQueue queue = new LinkedListQueue();

        DSAGraphNode node = (DSAGraphNode)vertices.peekFirst(); //peek the first value in the linked list
        System.out.println("Starting Node: " +node.getLabel()); //print it out
        queue.enqueue(node); // enqueue it
        node.setVisited(); // set it as visited
        while(!queue.isEmpty()) //run while loop
        {
            DSAGraphNode neighbour  =(DSAGraphNode)queue.top(); //peek the top node
            System.out.print(neighbour.getLabel() + " "); //print out the node
            queue.dequeue(); //dequeue it

            //run for each loop
            for (Object object : neighbour.getAdjacent())
            {
                DSAGraphNode v = (DSAGraphNode)object;
                if (v.getVisited() == false) //check if the node already visited
                {
                    //if  not, enqueue it and set as visited
                    queue.enqueue(v);
                    v.setVisited();
                }
            }
        }
        System.out.println(" ");
        clearVisited(); //clear visited

    }
}