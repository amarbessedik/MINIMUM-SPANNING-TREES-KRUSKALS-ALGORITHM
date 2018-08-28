/**
 * @author Amar Bessedik 
 * This class designs a disjoint set data structure using an array of ints.
 * The index represents the label of a set. The cell content hold vertices.
 */
public class DisjointSet
{
   private int[] set;//Holds graph's vetices represented by their labels.
   private int N;//# of subsets where labels start from 1 up to N included.

   /**
    * Constructor
     * @param n
    *
    */
   public DisjointSet(int n)
   {
      this.N = n;
      initializeSubsets(N);
   }//end Constructor

   private void initializeSubsets(int n)
   {  
      this.set = new int[n + 1];
      //Notice that we start from 1
      for (int x = 1; x <= n; x++)
         this.set[x] = x;
   }//end initializeSubsets()

   /**
    * Finds the label of a vertex and does path compression along the way.
    * @param x is a vertex
    * @return the label of x.
    */
   public int find2(int x)
   {
      int r = x;
      while (r != set[r]) //If x is not its own representative (label)
         r = set[r];
    
      int i = x;
      int j;
       
      while (i != r) //Proceed to path compression only if x != set[x]
      {
         j = set[i];
         set[i] = r;
         i = j;
      }//All visited nodes would have been updated to point to same representative.
      return r;
   }//end find2()


   /**
    * merges two vertices in different disjoint sets into one disjoint set.
    *
    * @param a
    * @param b
    */
   public void merge(int a, int b)
   {
      if (a < b)
         set[b] = a;
      else
         set[a] = b; 
   }//end merge()

   //Helps in debugging and to display the effect of path compression.
   private void showPathCompression(int[] d_set)
   {
      for (int u : d_set)
         System.out.printf("%3d", d_set[u]);
      System.out.println();
   }//end showPathCompression()
}//end class
