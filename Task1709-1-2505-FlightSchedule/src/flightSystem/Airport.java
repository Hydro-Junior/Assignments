package flightSystem;

import java.util.ArrayList;

public class Airport {
	private String name;
	private ArrayList<Flight> flights = new ArrayList<Flight>();

	

	public Airport(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public boolean wasVisitedBy(Flight f) {
		boolean flag = false;
		for (int i = 0; i < flights.size() && f != null; i++) {
			if (f.equals(flights.get(i))) {
				flag = true;
				break;
			}
		}
		return flag;

	}

	public boolean onSameFlight(Airport a1) {
		boolean flag = false;
		for(int i = 0 ; i < a1.getFlights().size(); i++){
			if(this.flights.contains(a1.getFlights().get(i))) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void addFlight(Flight f) {
		this.flights.add(f);
		f.getAirports().add(this);
	}

	public boolean equals(Airport a1) {
		boolean flag = true;
		if (this.name != a1.getName()) {
			return false;
		}
		if (a1.getFlights().size() != this.getFlights().size()) {
			return false;
		} else {
			for (int i = 0; i < this.getFlights().size(); i++) {
				if (!this.flights.contains(a1.getFlights().get(i))) {
						flag = false;
						break;
					
				}		
			}
		}

		return flag;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + " (");
		if (flights.size() == 0) {
			sb.append(")");
			return sb.toString();
		}
		for (int i = 0; i < flights.size(); i++) {
			if (i != flights.size() - 1) {
				sb.append(flights.get(i).getName() + ", ");
			} else {
				sb.append(flights.get(i).getName() + ")");
			}
		}
		return sb.toString();
	}

}
