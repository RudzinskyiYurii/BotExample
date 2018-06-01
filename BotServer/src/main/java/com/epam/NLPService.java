package com.epam;

public class NLPService implements NLPMessage{

	private String inputUserMessage;
	private String processedUserMessage;
	
	public NLPService(String userMessage) {
		load(userMessage);
		doSmthStaff();
	}
	
	@Override
	public void load(String message) {
		this.inputUserMessage = message;
	}

	private void doSmthStaff() {
		if (inputUserMessage.toLowerCase().contains("hello")) {
			processedUserMessage = "hello";
		}
		else
			processedUserMessage = "empty";
	}
	
	
	@Override
	public String result() {
		return processedUserMessage;
	}
	

}
