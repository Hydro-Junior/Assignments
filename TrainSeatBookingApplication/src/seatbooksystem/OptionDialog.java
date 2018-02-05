package seatbooksystem;

public class OptionDialog {
	
	public static void printOpreratorOption(TrainOperator[] to) {
		System.out.println("Which train operator would you like to travel with?");	
		System.out.println("1: "+to[0]);
		System.out.println("2: "+to[1]);
	}
	
	public static void printJourneyOptions(TrainJourney[] jn) {
		System.out.println("Which train journey would you like to book a seat on?");
		System.out.println("1: "+jn[0]);
		System.out.println("2: "+jn[1]);
	}
	public static void printBookOptions() {
		System.out.println("1. Book in First Class\n" + "2. Book in Economy Class\n" + "3. Show Floor Grid\n" + 
				"4. Quit");
	}
	public static void printSeatTypeOptions() {
		System.out.println("Which seat type?\n" + "1. WINDOW\n" + "2. AISLE\n" + "3. MIDDLE");
	}

}
