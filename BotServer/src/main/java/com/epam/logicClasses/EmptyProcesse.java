package com.epam.logicClasses;

public class EmptyProcesse extends AbstractLogicStaff{
private String result;
	
	
	public void sendEmptyText() {
		result = "Empty";
	}
	
	@Override
	public boolean processed(String... args) {
		sendEmptyText();
		status = true;
		return status;
	}

	public String getResultMessage() {
		return result;
	}

}
