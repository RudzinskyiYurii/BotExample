package com.epam.NLP;

import java.util.ArrayList;
import java.util.List;

public class NLPService implements NLPMessage{

	private String inputUserMessage;
	private List<String> processedUserMessage = new ArrayList<>();
	
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
			processedUserMessage.add(0, "hello");
		}
		else if (inputUserMessage.toLowerCase().contains("booking") & inputUserMessage.toLowerCase().contains("room")) {
			processedUserMessage.add(0, "booking");
			processedUserMessage.add(1, getRoom());
			processedUserMessage.add(2, getTime());
		}
		else
			processedUserMessage.add(0, "empty");
	}
	
	
	@Override
	public List<String> result() {
		return processedUserMessage;
	}
	
	private String getRoom() {
		String room = "";
		StringBuilder subString = new StringBuilder(inputUserMessage);
		int from = subString.indexOf("room") + 4;
		int to = subString.indexOf("at") - 1;
		room = subString.substring(from, to);
		return room;
	}
	
	private String getTime() {
		String time = "";
		int to = 0;
		StringBuilder subString = new StringBuilder(inputUserMessage);
		int from = subString.indexOf("at") + 2;
		if (subString.charAt(subString.length() - 1) == '.' ) 
			to = subString.length() - 1;
		else
			to = subString.length();
		time = subString.substring(from, to);
		return time;
	}
	
	
}
