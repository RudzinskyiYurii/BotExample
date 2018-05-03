package com.example.demo;

import java.util.LinkedList;
import java.util.List;

public class Logger {

	private List<Message> messages = new LinkedList<>();
	
	public void log (Message message) {
		messages.add(message);
	}
	
	public void prefics () {
		System.out.println("Created by Anonymous.");
	}

	@Override
	public String toString() {
		return "Logger [messages=" + messages + "]";
	}
	
}
