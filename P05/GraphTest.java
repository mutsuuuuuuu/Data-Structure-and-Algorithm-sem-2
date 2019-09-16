public class GraphTest
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();


        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("A","D");
        graph.addEdge("B","C");
        graph.addEdge("B","D");

        System.out.println("Edge Count " +graph.getEdgeCount());
        System.out.println("Vertex Count " +graph.getVertexCount());

        graph.displayAsList();



    }
}
