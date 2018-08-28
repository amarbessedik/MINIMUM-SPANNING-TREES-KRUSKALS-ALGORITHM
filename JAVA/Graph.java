import java.io.*;
import java.util.*;

/**
 * @author Amar Bessedik
 * This class designs a graph. Each instance reads in data 
 * which represents a graph from a text file.
 * Tests the validity of the data.
 * Extracts the number of vertices from the first line of the file.
 * and generates an edge from from each subsequent line.
 * Put the constructed edges into a list.
 */
public final class Graph {
   private ArrayList<Edge> edges;
   private int numOfVertices;
   private String data;

   /**
    * Constructor
    * @param filename
    * DESIGN CHOICES:
    * A list is used as we don't necessarily know how many edges are there.
    * This saves O(n) time that is needed to go through the files to count the edges.
    */
   public Graph(String filename) {
      this.data = filename;
      this.edges = new ArrayList<>();
      this.numOfVertices = 0;
      readData(data);
   }//end Constructor

   /** @param data */
   public void readData(String data) {
      int vertex1, vertex2, weight;
   
      try {
         Scanner reader = new Scanner(new File(data));
         //read first line and get # of vertices
         numOfVertices = Integer.parseInt(reader.nextLine());
      
         //A line has the form: VERTEX1 VERTEX2 WEIGHT
         while (reader.hasNextInt()) {
            vertex1 = reader.nextInt();
            vertex2 = reader.nextInt();
            weight  = reader.nextInt();
         
            //Alert if a given edge's parameters are invalid 
            //such as vertices are the same or weight is negative
            validateEdge(vertex1, vertex2, weight);
            //Generate an edge and add it to the list of edges
            edges.add(new Edge(vertex1, vertex2, weight));
         }
      } catch (FileNotFoundException | NumberFormatException e) {
         System.out.println(e);
      }
   }//end readData

   /** @return all edges of the graph as an array */
   public Edge[] getEdges() {
      return edges.toArray(new Edge[edges.size()]);
   }//end getEdges

   /** @return the number of vertices [1 ... n] */
   public int getVertices() {
      return numOfVertices;
   }//end getVertices

   /**@param vertex1 one the vertices of the graph
    * @param vertex2 the other vertex
    * @param weight  of an edge
    */
   public void validateEdge(int vertex1, int vertex2, int weight) {
      if ((vertex1 == vertex2) || (vertex1 < 1 || vertex2 < 1)
        || (vertex1 > numOfVertices || vertex2 > numOfVertices) || (weight < 0)) {
         throw new IllegalArgumentException("Invalid data");
      }
   }//end validateEdge
}//end Graph class
