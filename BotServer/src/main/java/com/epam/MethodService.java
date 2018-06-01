package com.epam;

import java.util.HashMap;
import java.util.Map;

import com.epam.logicClasses.EmptyProcesse;
import com.epam.logicClasses.HelloProcesse;
import com.epam.logicClasses.LogicStaff;

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
	}

	private void addHelloMethod() {
		HelloProcesse helloProcesse = new HelloProcesse();
		methods.put("hello", helloProcesse);
	}
	private void addEmptyMethod() {
		methods.put("empty",new EmptyProcesse());
	}


}
