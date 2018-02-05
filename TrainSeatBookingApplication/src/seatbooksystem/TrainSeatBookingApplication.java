package seatbooksystem;

import java.util.Scanner;

public class TrainSeatBookingApplication {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// set two train operators
		TrainOperator[] to = new TrainOperator[2];
		to[0] = new TrainWay("TrainWay");
		to[1] = new ChooChoo("ChooChoo");
		// set two train journeys
		TrainJourney[] tj = new TrainJourney[2];
		tj[0] = new TrainJourney("London", "York", "17:00h", "TJ1000", new GrandeFloorGrid());
		tj[1] = new TrainJourney("Swansea", "Sheffield", "08:00h", "TJ2000", new PetiteFloorGrid());

		//configure the floorGrid situation using the methods in FloorGrid class
		
		tj[0].getFloorGrid().configTrainWayFirstB();
		//tj[1].getFloorGrid().configChooChooEconoB();
		//tj[1].getFloorGrid().configChooChooFirstC();
		tj[1].getFloorGrid().configTrainWayFirstC();
		
		int indexOfOperator = 0;
		int indexOfJourney = 0;
		TrainJourney journeyChosen = null;
		TrainOperator operatorChosen = null;
		// choose the operator
		while (true) {
			OptionDialog.printOpreratorOption(to);
			String choice = sc.next();
			if (choice.equals("1") || choice.equals("2")) {
				indexOfOperator = Integer.parseInt(choice) - 1;
				operatorChosen = to[indexOfOperator];
				System.out.println("Menu Item " + choice + " selected");
				System.out.println("Welcome to the " + to[indexOfOperator] + " booking system");
			} else {
				System.out.println("Invalid input!Please make your choice again!");
				continue;
			}
			while (true) {
				OptionDialog.printJourneyOptions(tj);
				choice = sc.next();
				if (choice.equals("1") || choice.equals("2")) {
					indexOfJourney = Integer.parseInt(choice) - 1;
					journeyChosen = tj[indexOfJourney];
					System.out.println("Menu Item " + choice + " selected");
					System.out.println("Booking seats for " + tj[indexOfJourney]);
					FloorGrid fgSelected = journeyChosen.getFloorGrid();
					System.out.println(fgSelected);
					while (true) {
						OptionDialog.printBookOptions();
						choice = sc.next();
						if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
							System.out.println("Menu Item " + choice + " selected");
							int bookItemChosen = Integer.parseInt(choice);
							if (bookItemChosen == 1 || bookItemChosen == 2) {
								Seat seatBooked = new Seat();
								while (true) {
									OptionDialog.printSeatTypeOptions();
									choice = sc.next();
									if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
										System.out.println("Menu Item " + choice + " selected");
										int seatItemChosen = Integer.parseInt(choice);
										switch (seatItemChosen) {
										case 1:
											if (bookItemChosen == 1) {
												// book in first class
												seatBooked = operatorChosen.bookFirstClass(journeyChosen,
														SeatType.WINDOW);
											} else {
												// Book in Economy Class
												seatBooked = operatorChosen.bookEconomy(journeyChosen, SeatType.WINDOW);
											}
											break;
										case 2:
											if (bookItemChosen == 1) {
												// book in first class
												seatBooked = operatorChosen.bookFirstClass(journeyChosen,
														SeatType.AISLE);

											} else {
												// Book in Economy Class
												seatBooked = operatorChosen.bookEconomy(journeyChosen, SeatType.AISLE);
											}
											break;
										case 3:
											if (bookItemChosen == 1) {
												// book in first class
												seatBooked = operatorChosen.bookFirstClass(journeyChosen,
														SeatType.MIDDLE);

											} else {
												// Book in Economy Class
												seatBooked = operatorChosen.bookEconomy(journeyChosen, SeatType.MIDDLE);
											}
											break;
										}
										if (seatBooked != null && seatBooked.getOtherInfo() == null) {
											System.out.println(seatBooked.detaiedDescription());
											break;
										} else if (seatBooked != null
												&& seatBooked.getOtherInfo() == "entire row reserved") {
											System.out.println("The entire row where seat " + seatBooked.getSeatPosition()
													+ " is located has been reserved");
											break;
										} else {
											System.out.println("Sorry, we could not book the requested seat");
											break;
										}
									} else {
										System.out.println("Invalid input!Please make your choice again!");
										continue;
									}

								}

							}
							if (bookItemChosen == 3) {
								System.out.println(journeyChosen.getFloorGrid());
							}
							if (bookItemChosen == 4) {
								System.out.println("GoodBye.");
								System.exit(0);
							}

						} else {
							System.out.println("Invalid input!Please make your choice again!");
							continue;
						}
					}

				} else {
					System.out.println("Invalid input!Please make your choice again!");
					continue;
				}
			}

		}

	}
}
