package microwaveModel;

import org.junit.*;
import static org.junit.Assert.*;

public class DiaryTest
{
   
  private Diary calendar;

  @Before
  public void setUp()
  {
    calendar = new Diary();
  }
  
  @Test
  public void testAddGetAppointment1()
  {
    calendar.addAppointment(2, new Appointment(14, "Test"));
    assertNotNull(calendar.getAppointment(2, 14));
    assertEquals(calendar.getAppointment(2, 14).getDescription(), "Test");
  }
  
  @Test
  public void testAddGetAppointment2()
  {    
    calendar.addAppointment(1, new Appointment("4pm", "Lab"));
    assertNotNull(calendar.getAppointment(1, 16));
    assertEquals(calendar.getAppointment(1, 16).getDescription(), "Lab");
  }
  
  @Test
  public void testAddGetAppointment3()
  {
    calendar.addAppointment(-1, new Appointment(14, "Test"));
    assertNull(calendar.getAppointment(-1, 14));
  }
  
  @Test
  public void testAddGetAppointment4()
  {    
    calendar.addAppointment(1, new Appointment(19, "Test"));
    assertNull(calendar.getAppointment(1, 19));
  }
  
  @Test
  public void testAddGetAppointment5()
  {
    calendar.addAppointment(7, new Appointment(14, "Test"));
    assertNull(calendar.getAppointment(7, 14));
  }
  
  @Test
  public void testAddGetAppointment6()
  {
    calendar.addAppointment(2, new Appointment(6, "Test"));
    assertNull(calendar.getAppointment(2, 6));
  }
  
  @Test
  public void testAddGetAppointment7()
  {
    calendar.addAppointment(5, new Appointment("9am", "Office Hours"));
    assertNotNull(calendar.getAppointment(5, 9));
    assertEquals(calendar.getAppointment(5, 9).getDescription(), "Office Hours");
  }
  
  @Test
  public void testAddGetAppointment8()
  {        
    calendar.addAppointment(5, new Appointment("9am", "Grading"));
    assertNotNull(calendar.getAppointment(5, 9));
    assertEquals(calendar.getAppointment(5, 9).getDescription(), "Grading");  
  }  
}

