/**
 * @author Amar Bessedik 
 * This class implements the heapSort algorithm. It is adapted to sort an array 
 * of n Edges in increasing order of weight.
 */
public class HeapSort
{
   /**
    * Constructor
    */
   public HeapSort()
   {
   }

   /**
    * @param E and array of graph edges
    * @param n length of the array E
    */
   public void heapSort(Edge[] E, int n)
   {
      //Build a heap where root is the largest
      buildHeap(E, n);
      //Extract edges from heap one by one
      for (int i = n - 1; i >= 0; i--)
      {
         //Swap root (largest weight) to the end of array
         swap(E, 0, i);
         //Rebuild the reduced heap.
         heapify(E, 0, i);
      }
   }//end heapSort

   /**
    * @param E array of a graph edges
    * @param n length of the array E
    */
   private void buildHeap(Edge[] E, int n)
   {
      for (int i = (n / 2); i >= 0; i--)
      {
         heapify(E, i, n);
      }
   }//end heapify

   /**
    * @param E array of a graph edges
    * @param i index from which start make a heap.
    * @param n length of the array E.
    */
   private void heapify(Edge[] E, int i, int n)
   {
      int largest = i;// Initialize largest as i
      int l = left_child(i);// l = 2*i + 1
      int r = right_child(i);// r = 2*i + 2
   
      // If left child's weight is greater than root's weight
      if (l < n && E[l].getWeight() > E[largest].getWeight())
      {
         largest = l;
      }
      // If right child's weight is greater than root's weight
      if (r < n && E[r].getWeight() > E[largest].getWeight())
      {
         largest = r;
      }
      // If largest is not i
      if (largest != i)
      {
         //swap i with largest
         swap(E, i, largest);
         //heapify the reduced heap recursively
         heapify(E, largest, n);
      }
   }//end heapify

  //=========== HELPER METHODS ===============
   /**
    * @param E array of a graph edges
    * @param i the edge at index i goes to index j.
    * @param j the edge at index j goes to index i.
    */
   private void swap(Edge[] E, int i, int j)
   {
      Edge tmp = E[i];
      E[i] = E[j];
      E[j] = tmp;
   }//end swap

   /**
    * @param i index of a root edge
    * @return the left child of root.
    */
   private int left_child(int i)
   {
      return 2 * i + 1;
   }//end let_child

   /**
    * @param i index of a root edge
    * @return the right child of root.
    */
   private int right_child(int i)
   {
      return 2 * i + 2;
   }//end right_child

//================================================
}//end class
