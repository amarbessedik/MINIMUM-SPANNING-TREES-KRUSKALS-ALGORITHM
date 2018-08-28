/**
 * @author Amar Bessedik 
 * This program user executes Kruskal's algorithm on 3 different graphs 
 * and computes their Minimum Spanning Trees. 
 * CSC560 - Kruskal Project.
 */
public class KruskalUser
{
    static Edge[] E;//Hold a graph's edges
    static int V, i;//"V" is # of vertices, "i" is a counter.

    public static void main(String[] args)
    {
        final String[] Title =
        {
            "1ST GRAPH: ", "2ND GRAPH: ", "3RD GRAPH: "
        };
        
        String p = "C:\\Users\\Amar-cs\\Desktop\\CSC560\\Kruskals_project\\";
        Graph G1 = new Graph(p + "data1");//Graph 1.
        Graph G2 = new Graph(p+ "data2");//Graph 2.
        Graph G3 = new Graph(p + "data3");//Graph 3.
        

        Graph[] graphs = {G1, G2, G3};//array of graphs.

        Kruskal k;//Kuskal instance.

        for (Graph G : graphs)
        {
            k = new Kruskal(G);//Kruskal's object.
            System.out.println(Title[i++]);//print graph's title.

            get_params(G);//extract edges and # of vertices from the graph.

            k.kruskal(V, E);//Run Kruskal's Algorithm on G's parameters.
        }//end for
    }//end main

    private static void get_params(Graph G)
    {
        E = G.getEdges();// get edges of G.
        V = G.getVertices();//get # of vertices of G.
    }//end get_params
}//end main class
