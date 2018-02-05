package seatbooksystem;

public class TrainJourney {
	
	private String startCity;
	private String destinationCity;
	private String departureTime;
	private String journeyNumber;
	private FloorGrid floorGrid;
	
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getJourneyNumber() {
		return journeyNumber;
	}
	public void setJourneyNumber(String journeyNumber) {
		this.journeyNumber = journeyNumber;
	}
	public FloorGrid getFloorGrid() {
		return floorGrid;
	}
	public void setFloorGrid(FloorGrid floorGrid) {
		this.floorGrid = floorGrid;
	}
	
	@Override
	public String toString() {
		return "Journey: " + this.journeyNumber + " from: " + this.startCity + " to: " +
				this.destinationCity + " departing: " + this.departureTime;
	}
	
	public TrainJourney(String startCity, String destinationCity, String departureTime, String journeyNumber,
			FloorGrid floorGrid) {
		super();
		this.startCity = startCity;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.journeyNumber = journeyNumber;
		this.floorGrid = floorGrid;
	}
	
	
	
	
}
