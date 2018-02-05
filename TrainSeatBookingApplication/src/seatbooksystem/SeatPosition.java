package seatbooksystem;

public class SeatPosition {
	private int row;
	private char column;
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public void setColumn(char column) {
		this.column = column;
	}
	
	public SeatPosition() {
		super();
	}
	
	public SeatPosition(int row, char column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	
	
	@Override
	public String toString() {
		return this.row + "" + this.column;
	}
	
}
