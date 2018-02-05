package microwaveModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Appointment {

	private int hour;
	private String description;

	public Appointment(int hour, String description) {
		super();
		this.hour = hour;
		this.description = description;
	}

	public Appointment(String time, String description) {
		this.setTime(time);
		this.description = description;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTime(String s) {
		//It's easier to use Regular expression.
		String am = "(\\d+)am";
		String pm = "(\\d+)pm";
		int hour = 0;
		Pattern p1 = Pattern.compile(am);
		Pattern p2 = Pattern.compile(pm);
		if (s.matches(am)) {
			Matcher m1 = p1.matcher(s);
			m1.find();
			hour = Integer.parseInt(m1.group(1));
			if(hour == 12) {
				hour = 0;
			}
		} else if (s.matches(pm)) {
			Matcher m2 = p2.matcher(s);
			m2.find();
			hour = Integer.parseInt(m2.group(1));
			if(hour != 12) {
			hour = Integer.parseInt(m2.group(1)) + 12;
			}else {
				hour = 12;
			}
		}
		this.hour = hour;
	}

	@Override
	public String toString() {
		String time = new String();
		if(this.hour > 12) {
			time = (this.hour - 12) + "pm: ";
		}else if(this.hour == 12){
			time = 12 + "pm: ";
		}else if(this.hour == 0){
			time = 12 + "am: ";
		}else{
			time = this.hour + "am: ";
		}
		return time + this.description ;
	}

	
}
