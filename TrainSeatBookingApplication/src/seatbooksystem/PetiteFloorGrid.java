package seatbooksystem;

public class PetiteFloorGrid extends FloorGrid {

	@Override
	public void initialiseFloorGrid() {
		this.rowsNumber = 10;
		this.columnsNumber = 7;
		this.firstClassRows = 4;
		this.allSeats = new Seat[rowsNumber][columnsNumber];
		
		//build Seat Objects of specific Grade according to firstClassRows
		for(int i = 0 ; i < firstClassRows; i++) {
			for(int j = 0 ; j < columnsNumber ; j++) {
				allSeats[i][j] = new Seat(Grade.First);
			}
		}
		for(int i = firstClassRows ; i < rowsNumber ; i++ ) {
			for(int j = 0 ; j < columnsNumber ; j++) {
				allSeats[i][j] = new Seat(Grade.Economy);
			}
		}
		
		//set the SeatType
		for(int j = 0 ; j < columnsNumber; j++) {
			if(j == 0 || j == columnsNumber-1) {                   
				for(int i = 0 ; i < rowsNumber ; i++) {
					allSeats[i][j].setType(SeatType.WINDOW);
				}
			}else if (j == 3) {
				for(int i = 0 ; i < rowsNumber ; i++) {
					allSeats[i][j].setType(SeatType.MIDDLE);
				}
			}else {
				for(int i = 0 ; i < rowsNumber ; i++) {
					allSeats[i][j].setType(SeatType.AISLE);
				}
			}
		}
		
		for(int i = 0 ; i < rowsNumber; i++) {
			for(int j = 0 ; j < columnsNumber ; j++) {
				//add a set method in Seat class to translate 2Darray to floor grid
				allSeats[i][j].setSeatPosition(i, j); 
			}
		}
			
	}

	public PetiteFloorGrid() {
		initialiseFloorGrid();
	}
	
	
	

	

}
