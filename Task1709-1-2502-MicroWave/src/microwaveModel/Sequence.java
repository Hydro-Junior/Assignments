package microwaveModel;

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
  
   private int[] values;
   private int size;

 
	public Sequence(int capacity)
   {
      values = new int[capacity];
      size = 0;
   }
   
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
	   StringBuilder sbd = new StringBuilder();
	   if(values.length < 3) {
		   for(int i = 0 ; i < values.length - 1; i++) {
			   sbd.append(values[i]+" ");
		   }
		   sbd.append(values[values.length -1]);
		   return sbd.toString();
	   }
	   int[] repeatCount = new int[values.length]; 
	   int start = values[0];
	   int cursor = 1;
	   int i = 0;
	   while(cursor < values.length) {
		    i = cursor - 1;
		    while(values[cursor] == start) {
		    	repeatCount[i] ++;
		    	cursor ++;
		    	if(cursor == values.length) {
		    		break;
		    	}
		    }
		    if(cursor < values.length) {
				start = values[cursor];
				cursor++;
		    }
	   }
	   for(int j = 0 ; j < repeatCount.length ;) {
		   if(repeatCount[j] == 0) {
			   sbd.append(values[j]);
			   if(j < repeatCount.length -1 ) {
				   sbd.append(" ");
			   }
			   j++;
		   }else {
			   sbd.append("(" + values[j]); 
			   for(int k = 0 ; k < repeatCount[j];k++) {
				   sbd.append(" " + values[j]);
			   }
			   sbd.append(")");
			   if(j+repeatCount[j] < repeatCount.length -1 ) {
				   sbd.append(" ");
			   }
			   j += repeatCount[j]+1;
		   }
	   }
	   return sbd.toString();
      
   }
}
                                               
