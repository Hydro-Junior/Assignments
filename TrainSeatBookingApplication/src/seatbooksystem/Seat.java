package seatbooksystem;

import org.junit.Test;

public class Seat {
	private boolean isBooked;
	private Grade grade;
	private SeatType type ;
	private SeatPosition seatPosition = new SeatPosition();
	private String otherInfo;

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public SeatType getType() {
		return type;
	}

	public void setType(SeatType type) {
		this.type = type;
	}

	public SeatPosition getSeatPosition() {
		return seatPosition;
	}

	public void setSeatPosition(SeatPosition seatPosition) {
		this.seatPosition = seatPosition;
	}
	
	
	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	//translate 2Darray position to floor grid position
	public void setSeatPosition(int i , int j) {
		int row = i + 1;
		char column = (char) (65 + j);
		SeatPosition sp = new SeatPosition(row,column);
		this.seatPosition = sp;
	}

	@Override
	public String toString() {
		String seatLogo = new String();
		if (this.grade == Grade.First) {
			switch (this.type) {
			case AISLE:
				if (this.isBooked == true) {
					seatLogo = "[A X]";
				}else {
					seatLogo = "[A _]";
				}
				break;
			case MIDDLE:
				if (this.isBooked == true) {
					seatLogo = "[M X]";
				}else {
					seatLogo = "[M _]";
				}
				break;
			case WINDOW:
				if (this.isBooked == true) {
					seatLogo = "[W X]";
				}else {
					seatLogo = "[W _]";
				}
				break;
			}
		}else {
			switch (this.type) {
			case AISLE:
				if (this.isBooked == true) {
					seatLogo = "[a X]";
				}else {
					seatLogo = "[a _]";
				}
				break;
			case MIDDLE:
				if (this.isBooked == true) {
					seatLogo = "[m X]";
				}else {
					seatLogo = "[m _]";
				}
				break;
			case WINDOW:
				if (this.isBooked == true) {
					seatLogo = "[w X]";
				}else {
					seatLogo = "[w _]";
				}
				break;
			}
		}
		return seatLogo;
		
	}

	public String detaiedDescription() {
		String description;
		if (this.isBooked == false) {
			description = "Seat reservation: " + this.grade + " class " + this.type + " seat at:" + this.seatPosition + " " + "is not booked.";
		} else {
			description = "Seat reservation: " + this.grade + " class " + this.type + " seat at:" + this.seatPosition + " " + "is reserved.";
		}
		return description;
	}
	
	
	
	
	public int get2Drow() {
		return this.getSeatPosition().getRow()-1;
	}
	public int get2Dcolumn() {
		return this.getSeatPosition().getColumn()-65;
	}
	
	public Seat() {
		super();
	}
	
	
	public Seat(Grade grade) {
		super();
		this.grade = grade;
	}

	public Seat(SeatPosition seatPosition) {
		super();
		this.seatPosition = seatPosition;
	}



}

enum SeatType {
	AISLE, MIDDLE, WINDOW;
}

enum Grade {
	Economy, First;
}
