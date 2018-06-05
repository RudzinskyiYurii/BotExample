package com.epam.logicClasses;

public class RoomBookingProcesse extends AbstractLogicStaff{

	
	public RoomBookingProcesse() {
	}
	
	@Override
	public boolean processed(String... args) {
		
		for (String arg : args)
			if (arg.equals(null)){
				result = "Not enough arguments!";
				return false;
			}
//		if (args.length < 2) {
//			result = "Not enough arguments!";
//			return false;
//		}
			return magicBookingRoomMethod(args);
	}

	@Override
	public String getResult() {
		return result;
	}
	
	private boolean magicBookingRoomMethod(String... args) {
		System.out.println("Booking room: " + args[0] + "\n at " + args[1] + "." );
		result = new StringBuilder("Booking room: " + args[0] + "\n at " + args[1] + "." ).toString();
		return true;
		
	}

}
