package microwaveModel;

/**
 *  A class for representing a microwave oven.
 *
 *  @author 
 *  @version
 */
 
public class Microwave {

    private int time;
    private int level;

    public Microwave()
    {
        this.time = 0;
        this.level = 1;
    }
    
    
  
    public void increaseTime()
    {
      this.time += 30;
    }
    
    public void switchPower()
    {
      if(this.level == 1) {
    	  this.level = 2;
      }else {
    	  this.level = 1;
      }
    }
    
    /** 
     * Resets the microwave to its initial state.
     */
    public void reset()
    {
    	this.time = 0;
        this.level = 1;
    }
    
    /**
     * Starts the microwave.
     */ 
    public void start()
    {
       System.out.println("Cooking for " + this.time + " seconds at level " + this.level);
    }
   
}