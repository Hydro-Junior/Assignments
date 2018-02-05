package flightSystem;

import java.util.ArrayList;

public class Flight {
	private String name;
	private ArrayList<Airport> airports = new ArrayList<Airport>();
	private String date;

	public Flight(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}
	public void addAirport(Airport a) {
		this.airports.add(a);
		a.getFlights().add(this);
	}
	public boolean equals(Flight f1) {
		if(this.name == f1.getName() && this.date == f1.getDate())	{
			return true;
		}else {
			return false;
		}
	}
	//added method
	public boolean containsAirport(String name) {
		for(int i = 0 ; i < airports.size(); i++) {
			if(airports.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<Airport> getAirports() {
		return airports;
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	@Override
	public String toString() {
		 StringBuilder s1 = new StringBuilder();
		 s1.append(this.name + ", " + this.date );
		 for(int i = 0 ; i < airports.size(); i++) {
			s1.append(System.lineSeparator() + airports.get(i).getName());
		 }
		 return s1.toString();
	}
	
	
}
