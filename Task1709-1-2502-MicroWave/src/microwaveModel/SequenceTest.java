package microwaveModel;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class SequenceTest
{
  private final int TOSSES = 20;
  private Sequence sequence;
  
  @Before
  public void setUp()
  {
    sequence = new Sequence(TOSSES);
  }
  
  @Test
  public void testMarkRun1()
  {
    Random die = new Random(42);
    
    for (int i = 0; i < TOSSES; i++) 
    {
      sequence.add(die.nextInt(6) + 1);
    }
    
    assertEquals("3 4 1 3 1 2 6 3 2 6 (3 3) (1 1) (3 3) (1 1) 2 6", sequence.markRuns());
  }
  
  @Test
  public void testMarkRun2()
  {
    Random die = new Random(38);
    
    for (int i = 0; i < TOSSES; i++) 
    {
      sequence.add(die.nextInt(6) + 1);
    }     
    sequence.markRuns();
    assertEquals("1 6 (5 5) (2 2) 5 (3 3) 1 5 2 5 3 6 3 2 (3 3 3)", sequence.markRuns());
  }
  
  @Test
  public void testMarkRun3()
  {
    Random die = new Random(17);
    
    for (int i = 0; i < TOSSES; i++) 
    {
      sequence.add(die.nextInt(6) + 1);
    }     
    
    assertEquals("(1 1) 5 3 5 4 5 4 5 1 2 4 5 4 (1 1) 2 4 2 6", sequence.markRuns());
  }
  
}
