/**
 * @author Amar Bessedik 
 * This class designs a weighted graph's edge. An edge has
 * tow vertices represented by integers from 1 up to n.*/
public class Edge
{
   private int vertex1;//first vertex of an edge
   private int vertex2;//second of an edge
   private int weight;//weight of an adge

   /**
    * Constructor
    * @param vertex1 fisrt vertex
    * @param vertex2 second vertex
    * @param weight edge weight
    */
   public Edge(int vertex1, int vertex2, int weight)
   {
      this.vertex1 = vertex1;
      this.vertex2 = vertex2;
      this.weight = weight;
   }
   
   /**
    * @return the first vertex of an edge Reading is from left to right thus
    * edge = (first, second, weight) */
   public int getVertex1()
   {
      return vertex1;
   }

   /**
    * @return the second vertex of an edge Reading is from left to right thus
    * edge = (first, second, weight)*/
   public int getVertex2()
   {
      return vertex2;
   }

   /**
    * @return the weight of an edge */
   public int getWeight()
   {
      return weight;
   }

   @Override
   public String toString()
   {
      return String.format("%2d %4d %8d", this.vertex1, this.vertex2, this.weight);
   }//end toString()
}//end class
