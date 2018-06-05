package com.epam.core;

import java.util.HashMap;
import java.util.Map;

import com.epam.logicClasses.EmptyProcesse;
import com.epam.logicClasses.HelloProcesse;
import com.epam.logicClasses.LogicStaff;
import com.epam.logicClasses.RoomBookingProcesse;

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
