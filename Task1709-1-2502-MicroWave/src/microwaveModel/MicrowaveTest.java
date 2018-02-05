package microwaveModel;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class MicrowaveTest
{
  
  private Microwave microwave;
  private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

  @Before
  public void setUp()
  {
    microwave = new Microwave();
    System.setOut(new PrintStream(outStream));

  }
  
  @Test
  public void testStart()
  {
    microwave.start();
    assertEquals("Cooking for 0 seconds at level 1", outStream.toString().trim());
  }
  
  @Test
  public void testIncreaseTime1()
  {
    microwave.increaseTime();  
    microwave.start();
    assertEquals("Cooking for 30 seconds at level 1", outStream.toString().trim());
  }
  
  @Test
  public void testIncreaseTime2()
  {
    microwave.increaseTime();  
    microwave.increaseTime();
    microwave.increaseTime();
    microwave.start();
    assertEquals("Cooking for 90 seconds at level 1", outStream.toString().trim());
  }
  
  @Test
  public void testSwitchPower1()
  {
    microwave.increaseTime();  
    microwave.increaseTime();
    microwave.switchPower();
    microwave.start();
    assertEquals("Cooking for 60 seconds at level 2", outStream.toString().trim());
  }
  
  @Test
  public void testSwitchPower2()
  {
    microwave.switchPower();
    microwave.increaseTime();  
    microwave.increaseTime();
    microwave.increaseTime();
    microwave.increaseTime();
    microwave.switchPower();
    microwave.start();
    assertEquals("Cooking for 120 seconds at level 1", outStream.toString().trim());
  }
  
  @Test
  public void testReset()
  {
    microwave.switchPower();
    microwave.increaseTime();  
    microwave.increaseTime();
    microwave.increaseTime();
    microwave.increaseTime();
    microwave.switchPower();
    microwave.reset();
    microwave.start();
    assertEquals("Cooking for 0 seconds at level 1", outStream.toString().trim());
  }
}
