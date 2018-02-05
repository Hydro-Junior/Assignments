/**
 * This class marks "runs", i.e., adjacent repeated values, by
 * including them in parenthesis.
 * For example:
 * 1 2 (5 5) 3 1 2 4 3 (2 2 2 2) 3 6 (5 5) 6 3 1
 *
 *  @author 
 *  @version
 */

public class Sequence
{
  
  //~ Fields ................................................................
  
   private int[] values;
   private int size;

   //~ Constructor ...........................................................
   
   /**
    * Intializes the fields.
    * @param capacity the sie of the array
    */ 
   public Sequence(int capacity)
   {
      values = new int[capacity];
      size = 0;
   }
   
   //~ Methods ...............................................................
   
   /**
    * Adds the generated die roll value to the array.
    * @param value die roll value
    */ 
   public void add(int value)
   {
      if (size < values.length)
      {
         values[size] = value;
         size++;
      }
   }

   /**
    * Returns the string of values, with runs enclosed in parentheses.
    * @return the string of values with the runs marked
    * for example "1 2 (5 5) 3 1 2 4 3 (2 2 2 2) 3 6 (5 5) 6 3 1"
    */
   public String markRuns()
   {
      //your code here
   }
}
