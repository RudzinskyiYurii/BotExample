package com.epam.logicClasses;

public class HelloProcesse implements LogicStaff {

	private String result;
	
	public HelloProcesse() {
	}
	
	public void sendHello() {
		result = "Hello my friend!";
	}
	
	@Override
	public boolean processed(String... args) {
		sendHello();
		return true;
	}

	public String getResult() {
		return result;
	}
	
	
}
