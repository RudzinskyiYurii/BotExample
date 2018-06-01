package com.epam.logicClasses;

public class EmptyProcesse implements LogicStaff{
private String result;
	
	
	public void sendEmptyText() {
		result = "Empty";
	}
	
	@Override
	public boolean processed() {
		sendEmptyText();
		return true;
	}

	public String getResult() {
		return result;
	}
}
