package com.epam.logicClasses;

public class RoomBookingProcesse extends AbstractLogicStaff {


	public RoomBookingProcesse() {
	}

	@Override
	public boolean processed(String... args) {

		for (String arg : args)
			if (arg.equals(null)) {
				result = "Not enough arguments!";
				status = false;
				return status;
			}
		// if (args.length < 2) {
		// result = "Not enough arguments!";
		// return false;
		// }
		status = magicBookingRoomMethod(args);
		return status;
	}

	@Override
	public String getResultMessage() {
		return result;
	}

	private boolean magicBookingRoomMethod(String... args) {
		System.out.println("Booking room: " + args[0] + "\n at " + args[1] + ".");
		status = true;
		result = new StringBuilder("Booking room " + args[0] + "\nat " + args[1] + ".\n").append("Result status: ")
				.append(getPerformedWorkStatus()).toString();
		return status;

	}


}
