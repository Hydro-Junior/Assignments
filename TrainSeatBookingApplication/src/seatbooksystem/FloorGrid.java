package seatbooksystem;

public abstract class FloorGrid {

	public abstract void initialiseFloorGrid();

	protected Seat[][] allSeats;
	protected int rowsNumber;
	protected int columnsNumber;
	protected int firstClassRows;

	Seat getSeat(int row, char column) {

		return allSeats[row - 1][column - 65];
	}

	Seat getLeft(Seat seat) {
		// use get2Dcolumn and get2Drow methods to get position in 2Darray
		if (seat.get2Dcolumn() >= 1) {
			return allSeats[seat.get2Drow()][seat.get2Dcolumn() - 1];
		}
		return null;
	}

	Seat getRight(Seat seat) {
		if (seat.get2Dcolumn() < columnsNumber - 1) {
			return allSeats[seat.get2Drow()][seat.get2Dcolumn() + 1];
		}
		return null;
	}

	Seat getTheLastSeat() {
		return allSeats[rowsNumber - 1][columnsNumber - 1];
	}

	Seat queryAvailableEconomySeat(SeatType type) {
		for (int i = firstClassRows; i < rowsNumber; i++) {
			for (int j = 0; j < columnsNumber; j++) {
				if (allSeats[i][j].isBooked() == false && allSeats[i][j].getType() == type) {
					return allSeats[i][j];
				} else if (allSeats[i][j].isBooked() == false) {
					return allSeats[i][j];
				} else {
					return null;
				}
			}
		}
		return null;
	}

	Seat queryAvailableFirstClassSeat(SeatType type) {
		for (int i = 0; i < firstClassRows; i++) {
			for (int j = 0; j < columnsNumber; j++) {
				if (allSeats[i][j].isBooked() == false && allSeats[i][j].getType() == type) {
					return allSeats[i][j];
				} else if (allSeats[i][j].isBooked() == false) {
					return allSeats[i][j];
				} else {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder floorGrid = new StringBuilder();
		floorGrid.append(String.format("%8s", " "));
		floorGrid.append("©®");
		for (int j = 0; j < columnsNumber; j++) {
			floorGrid.append(" " + String.format("%-5c", j + 65));
		}
		floorGrid.append("\n");
		for (int i = 0; i < rowsNumber; i++) {
			floorGrid.append(String.format("%2d", i + 1) + " ");
			for (int j = 0; j < columnsNumber; j++) {
				floorGrid.append(allSeats[i][j] + " ");
			}
			floorGrid.append("\n");
		}

		return floorGrid.toString();
	}
	
	/**
	 * The following are methods for seat configuration.
	 */
	public void configTrainWayEconoB() {
		for(int i = firstClassRows; i < rowsNumber ; i ++) {
			for(int j = 0 ; j < columnsNumber; j++) {
				this.allSeats[i][j].setBooked(true);
			}
		}
	}
	public void configTrainWayEconoC() {
		this.configTrainWayEconoB();
		for(int j = 0 ; j < firstClassRows; j++ ) {
			this.allSeats[j][0].setBooked(true);
			this.allSeats[j][columnsNumber-1].setBooked(true);
		}
	}
	public void configTrainWayFirstC() {
		for(int i = 0; i < firstClassRows ; i ++) {
			for(int j = 0 ; j < columnsNumber; j++) {
				this.allSeats[i][j].setBooked(true);
			}
		}
	}
	public void configChooChooEconoB() {
		for(int j = firstClassRows; j < rowsNumber; j++ ) {
			this.allSeats[j][0].setBooked(true);
			this.allSeats[j][columnsNumber-1].setBooked(true);
		}
	}
	public void configChooChooFirstC() {
		this.configTrainWayEconoC();
	}
	
	public void configTrainWayFirstB() {
		for(int j = 0 ; j < firstClassRows; j++ ) {
			this.allSeats[j][0].setBooked(true);
			this.allSeats[j][columnsNumber-1].setBooked(true);
		}
	}
	public void configTrainWayFirstD() {
		for(int i = 0 ; i < rowsNumber ; i++) {
			for(int j = 0 ; j < columnsNumber ; j++) {
				this.allSeats[i][j].setBooked(true);
			}
		}
	}
	public void configChooChooFirstB() {
		this.configTrainWayFirstB();
	}
}
