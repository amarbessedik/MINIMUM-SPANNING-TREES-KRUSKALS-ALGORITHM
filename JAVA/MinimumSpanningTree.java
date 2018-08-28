import java.util.*;

/**
 * @author Amar Bessedik This class designs an Minimum Spanning Tree (or MST).
 * An MST is subgraph with minimum weight & without cycles of a connected graph.
 */
public class MinimumSpanningTree
{

    private ArrayList<Edge> mst;//list that grows as edges are added.
    private int weight;//total weight
    private int condition;//Kuruskal's terminating condition.
    private int V;//# of vertices of G. Needed as an MST must have (V - 1) edges.

    /**
     * Constructor
     *
     * @param G is a graph for which Kruskal finds its MST if it exists.
     */
    public MinimumSpanningTree(Graph G)
    {
        this.mst = new ArrayList<>();
        this.V = G.getVertices();
        this.condition = V - 1;
        this.weight = 0;
    }// end constructor

    /**
     * @param weight updates the weight of the MST.
     */
    public void update(int weight)
    {
        this.weight += weight;
    }//end update

    /**
     * @param e add e to MST
     */
    public void add(Edge e)
    {
        mst.add(e);
    }//end add

    /**
     * @return size of MST.
     */
    public int size()
    {
        return mst.size();
    }//end size

    /**
     * @return true if there are (V - 1) edges in the MST.
     */
    public boolean satisfied()
    {
        return size() == condition;
    }

    /**
     * Shows results after execution of the Kruskal's function.
     */
    public void output()
    {
        if (!satisfied())
        {
            System.out.println("THE GRAPH IS NOT CONNECTED! No MST.\n");
        String mstMessage = String.format("%s %4s %8s %s", "V1", "V2",
                                           "W","\n-----------------\n");
            for (Edge e : mst)
                mstMessage += e + "\n";
            mstMessage += "\nTOTAL WEIGHT: " + weight + "\n\n";
        System.out.println(mstMessage);
        }else
        {
            String mstMessage = "\nMINIMUM SPANNING TREE:\n\n";
            mstMessage += String.format("%s %4s %8s %s", "V1", "V2",
                                        "W","\n-----------------\n");
            for (Edge e : mst)
                mstMessage += e + "\n";
            mstMessage += "\nTOTAL WEIGHT: " + weight + "\n\n";

            System.out.println(mstMessage);
        }
    }//end mst_output
}//end MinimumSpanningTree class
