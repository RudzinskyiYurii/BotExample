package com.epam.logicClasses;

public class HelloProcesse extends AbstractLogicStaff {

	private String result;
	
	public HelloProcesse() {
	}
	
	public void sendHello() {
		result = "Hello my friend!";
	}
	
	@Override
	public boolean processed(String... args) {
		sendHello();
		status = true;
		return status;
	}

	public String getResultMessage() {
		return result;
	}

	
	
}
