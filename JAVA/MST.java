import java.util.*;


public class MST
{
   private ArrayList<Edge> mst;
   private int V;
   private int weight;
  
   public MST(int n)
   {  
      this.V = n;
      this.mst = new ArrayList<>();
      this.weight = 0;
   }
   
   public void update(int weight)
   {
    this.weight += weight;
   }
   
   public void add(Edge e){
      mst.add(e);
   }
   
   public int size()
   {
      return mst.size();
   }
  
   public void printMessage()
   {  
      String mstMessage = "\nMinimum Spanning Tree:\n\n";
      String noMST = "The graph is not connected! No MST.\n";
      String result = "";
      
      mstMessage += String.format("%s %4s %24s","V1", "V2", 
                                  "W\n---------------\n");
      
      for (Edge e : this.mst)
         if (e != null)
            mstMessage += e + "\n";
            
      mstMessage += "\nminimum cost: " + weight + "\n\n";
    
      result = (size() < V - 1)? noMST : mstMessage;
        
      System.out.print(result);
   }//end printMessage
}//end class