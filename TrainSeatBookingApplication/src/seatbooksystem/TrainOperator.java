package seatbooksystem;

public abstract class TrainOperator {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract Seat bookFirstClass(TrainJourney tj, SeatType type);
	public abstract Seat bookEconomy(TrainJourney tj, SeatType type);
	
	
	public TrainOperator(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return  this.name;
	}
	
	
	
	
}
