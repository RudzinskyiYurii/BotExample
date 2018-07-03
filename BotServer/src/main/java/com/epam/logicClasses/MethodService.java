package com.epam.logicClasses;

import java.util.HashMap;
import java.util.Map;

public class MethodService {

	public MethodService() {
		addAllMethods();
	}
	
	private Map<String, LogicStaff> methods = new HashMap<>();

	public Map<String, LogicStaff> getMethods() {
		return methods;
	}

	public void addAllMethods() {
		addHelloMethod();
		addEmptyMethod();
		addRoomBookingMethod();
	}

	private void addHelloMethod() {
		HelloProcesse helloProcesse = new HelloProcesse();
		methods.put("hello", helloProcesse);
	}
	private void addEmptyMethod() {
		methods.put("empty",new EmptyProcesse());
	}
	private void addRoomBookingMethod() {
		methods.put("booking", new RoomBookingProcesse());
	}


}
