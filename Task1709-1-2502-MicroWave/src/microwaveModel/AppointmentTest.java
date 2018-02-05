package microwaveModel;

import org.junit.*;
import static org.junit.Assert.*;

public class AppointmentTest
{
    //~ Fields ................................................................

    
    private Appointment appointment1;
    private Appointment appointment2;

    @Before
    public void setUp()
    {
        appointment1 = new Appointment("9pm", "Exam");
        appointment2 = new Appointment(10, "Lab");
    }
    
    @Test
    public void testGetSetHour()
    {
        assertEquals(appointment2.getHour(), 10);
        appointment2.setHour(2);
        assertEquals(appointment2.getHour(), 2);
    }

    @Test
    public void testGetSetDescription()
    {
        assertEquals(appointment2.getDescription(), "Lab");
        appointment2.setDescription("Office Hours");
        assertEquals(appointment2.getDescription(), "Office Hours");
    }

    @Test
    public void testSecondConstructor()
    {
        Appointment appointment3 = new Appointment("3pm", "CS 211");
        assertEquals(appointment3.getHour(), 15);
        assertEquals(appointment3.getDescription(), "CS 211");
    } 
 
    @Test
    public void testSetTime()
    {             
        assertEquals(appointment1.getHour(), 21);
        assertEquals(appointment1.getDescription(), "Exam");
        
        appointment1.setTime("12pm");
        assertEquals(appointment1.getHour(), 12);
        
        appointment1.setTime("11am");
        assertEquals(appointment1.getHour(), 11);
        
        appointment1.setTime("12am");
        assertEquals(appointment1.getHour(), 0);
        
        appointment1.setTime("5pm");
        assertEquals(appointment1.getHour(), 17);        
    }
    
    @Test
    public void testToString1()
    {
        assertEquals("10am: Lab", appointment2.toString());
        assertEquals("9pm: Exam", appointment1.toString());
    }
    
    @Test
    public void testToString2()
    {
        appointment2.setHour(0);
        assertEquals("12am: Lab", appointment2.toString());
        
        appointment1.setHour(12);
        assertEquals("12pm: Exam", appointment1.toString()); 
        
    }
}
