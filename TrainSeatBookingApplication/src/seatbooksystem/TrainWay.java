package seatbooksystem;


public class TrainWay extends TrainOperator {

	public TrainWay(String name) {
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
					seatChosen = fg.allSeats[i][j];
					break;
				}
			}
			
			if(seatChosen != null) {
				break;		
			}else {
				//If no such first-class seat with the matching type exists, then find and book any seat in first class
				for(int j = 0 ; j < fg.columnsNumber; j++) {
					if(fg.allSeats[i][j].isBooked()== false) {
						seatChosen = fg.allSeats[i][j];
						break;
					}
				}
				if(seatChosen != null) {
					break;
				}
			}
		}
		if(seatChosen == null) {
			//If there are no seats available in first class then instead book a window seat in economy
			for(int i = fg.firstClassRows; i < fg.rowsNumber; i++ ) {
				if(fg.allSeats[i][0].isBooked()== false) {
					seatChosen = fg.allSeats[i][0];
					break;
				}else if(fg.allSeats[i][fg.columnsNumber-1].isBooked()== false) {
					seatChosen = fg.allSeats[i][fg.columnsNumber-1];
					break;
				}
			}
		}
		if(seatChosen != null) {
			fg.allSeats[seatChosen.get2Drow()][seatChosen.get2Dcolumn()].setBooked(true);
		}
		System.out.println(fg);
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
					seatChosen = fg.allSeats[i][j];
					break;
				}
			}
			if(seatChosen != null) {
				break;		
			}
		}
		if(seatChosen == null) {
			// If no such economy class seat with the matching type exists, then find and book any window seat in first class
			for(int k = 0; k < fg.firstClassRows; k++ ) {
				if(fg.allSeats[k][0].isBooked()== false) {
					seatChosen = fg.allSeats[k][0];
					break;
				}else if(fg.allSeats[k][fg.columnsNumber-1].isBooked()== false) {
					seatChosen = fg.allSeats[k][fg.columnsNumber-1];
					break;
				}
			}
		}
		if(seatChosen != null) {
			fg.allSeats[seatChosen.get2Drow()][seatChosen.get2Dcolumn()].setBooked(true);
		}
		System.out.println(fg);
		return seatChosen;
	}
	
	


	

}
