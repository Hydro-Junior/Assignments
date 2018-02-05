package seatbooksystem;

public class ChooChoo extends TrainOperator {

	public ChooChoo(String name) {
		super(name);
	}

	@Override
	public Seat bookFirstClass(TrainJourney tj, SeatType type) {
		FloorGrid fg = tj.getFloorGrid();
		Seat seatChosen = null;
		for(int i = 0 ; i < fg.firstClassRows; i++) {
			//Find and book a seat in first class that matches the requested seat type
			for(int j = 0 ; j < fg.columnsNumber; j++) {
				if(fg.allSeats[i][j].isBooked()== false && fg.allSeats[i][j].getType()== type) {
					fg.allSeats[i][j].setBooked(true);
					seatChosen = fg.allSeats[i][j];
					break;
				}
			}
			if(seatChosen != null) {
				System.out.println(fg);
				break;		
			}
		}
		if(seatChosen == null) {
			//If no such first class seat with the matching type exists, then book an entire row in
			//economy class (for extra passenger room)
			
			//to judge whether the entire row is not booked
			boolean[] flag = new boolean[fg.rowsNumber] ; 
			
			for(int i = fg.firstClassRows ; i < fg.rowsNumber ; i++ ) {
				for(int j = 0; j < fg.columnsNumber ; j++) {
					if(fg.allSeats[i][j].isBooked() == true) {
						flag[i] = true;
					}
				}
			}
			for(int k = fg.firstClassRows ; k < fg.rowsNumber; k++) {
				if(flag[k] == false) {
					for(int j = 0 ; j < fg.columnsNumber ; j++) {
						fg.allSeats[k][j].setBooked(true);
					}
					seatChosen = fg.allSeats[k][0];
					System.out.println(fg);
					seatChosen.setOtherInfo("entire row reserved");
					break;
				}
			}
		}
		if(seatChosen == null) {
			System.out.println(fg);
		}
		return seatChosen;
	}

	@Override
	public Seat bookEconomy(TrainJourney tj, SeatType type) {
		FloorGrid fg = tj.getFloorGrid();
		Seat seatChosen = null;
		for(int i = fg.firstClassRows ; i < fg.rowsNumber; i++) {
			//Find and book a seat in economy class that matches the requested seat type
			for(int j = 0 ; j < fg.columnsNumber; j++) {
				if(fg.allSeats[i][j].isBooked()== false && fg.allSeats[i][j].getType()== type) {
					fg.allSeats[i][j].setBooked(true);
					seatChosen = fg.allSeats[i][j];
					break;
				}
			}
			if(seatChosen != null) {
				break;		
			}
		}
		System.out.println(fg);
		return seatChosen;
	}

}
