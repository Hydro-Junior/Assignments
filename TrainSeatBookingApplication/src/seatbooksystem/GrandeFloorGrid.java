package seatbooksystem;

public class GrandeFloorGrid extends FloorGrid {

	@Override
	public void initialiseFloorGrid() {
		this.rowsNumber = 12;
		this.columnsNumber = 9;
		this.firstClassRows = 6;
		this.allSeats = new Seat[rowsNumber][columnsNumber];
		
		for(int i = 0 ; i < firstClassRows; i++) {
			for(int j = 0 ; j < columnsNumber ; j++) {
				allSeats[i][j] = new Seat(Grade.First);
			}
		}
		for(int i = firstClassRows ; i < rowsNumber; i++ ) {
			for(int j = 0 ; j < columnsNumber ; j++) {
				allSeats[i][j] = new Seat(Grade.Economy);
			}
		}
		for(int j = 0 ; j < columnsNumber; j++) {
			if(j == 0 || j == columnsNumber-1) {
				for(int i = 0 ; i < rowsNumber ; i++) {
					allSeats[i][j].setType(SeatType.WINDOW);
				}
			}else if (j == 1 || j == 4 || j==7) {
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
				allSeats[i][j].setSeatPosition(i, j);
			}
		}
		
	}

	public GrandeFloorGrid() {
		initialiseFloorGrid();
	}
	
	

	

}
