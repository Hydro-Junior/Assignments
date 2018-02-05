package microwaveModel;
/**
 *  
 *
 *  @author 
 *  @version 
 */
public class Diary
{
    
	Appointment[][] appointments = null;
   
	public Diary() {
		this.appointments = new Appointment[7][10];
	}
	
    // ----------------------------------------------------------
    /**
     * Creates a new WeeklyCalendar object.
     */
        
    // Initialize your 2D array of appointments in the constructor
    


    //~ Methods ...............................................................

    /**
     * Add a new appointment on the specified day.  The time for the
     * appointment is extracted from the appointment object itself.
     * If the day is invalid, the method does nothing.  If the appointment
     * is outside the window of 8am-5pm, the method does nothing.
     * If another appointment has already been entered for the
     * specified day/time, it is removed and replaced by the one
     * being added.
     * 
     * @param day         The day for the appointment.
     * @param appointment The appointment to add on that day (contains
     *                    its own time).
     */
    
     public void addAppointment(int day , Appointment apm) {
    	 if(day < 0 || day > 6) {
    		 return;
    	 }
    	 int theHour = apm.getHour();
    	 if(theHour > 17 || theHour < 8) {
    		 return;
    	 }else {
    		 this.appointments[day][theHour - 8] = apm;
    	 }
     }


    // ----------------------------------------------------------
    /**
     * Retrieve an existing appointment (if any) by day and hour.
     * 
     * @param day  The day to check.
     * @param hour The hour to check, in military time.
     * @return The appointment at the specified day and time,
     * if there is one, or null if no appointment is found, if
     * the day specified is invalid, or if the hour specified is
     * outside the range 8-17.
     */
    
    public Appointment getAppointment(int day , int hour) {
    	if(day < 0 || day > 6 || hour < 8 || hour > 17) {
    		return null;
    	}
    	if(appointments[day][hour - 8] != null) {
    		return appointments[day][hour - 8];
    	}else {
    		return null;
    	}
    }
}