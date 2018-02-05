package flightSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightSchedule {
	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("src/FlightList.txt");
			Scanner sc = new Scanner(inputStream, "UTF-8");
			List<Flight> theFlights = new ArrayList<Flight>();
			int count = 0;
			while (sc.hasNext()) {
				String currentline = sc.nextLine();
				String[] res = currentline.split("(\\s+)|(\\|)");
				List<String> flightInfo = new ArrayList<>();
				for (int i = 0; i < res.length; i++) {
					// the res array may contain space String
					if (!res[i].equals("")) {
						flightInfo.add(res[i]);
					}
				}
				if (flightInfo != null) {
					theFlights.add(new Flight(flightInfo.get(0), flightInfo.get(1)));
					for (int i = 2; i < flightInfo.size(); i++) {
						theFlights.get(count).addAirport(new Airport(flightInfo.get(i)));
					}
				}
				count++;
			}
			//System.out.println(theFlights.get(0) + "\n" + theFlights.get(1) + "\n" + theFlights.get(2));
			while (true) {
				System.out.println("Enter the name of an airport : ");
				Scanner sc2 = new Scanner(System.in);
				String airport = sc2.next();
				if(airport.equals("exit")) {
					System.exit(0);
				}
				Airport a = new Airport(airport);
				boolean b = false;
				for (int i = 0; i < theFlights.size(); i++) {
					if (theFlights.get(i).containsAirport(airport)) {
						b = true;
						a.addFlight(theFlights.get(i));
					}
				}
				if (b == true) {
					System.out.println(a);
				} else {
					System.out.println("This is not a valid airport.");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found!");
			e.printStackTrace();
		}

	}
}
