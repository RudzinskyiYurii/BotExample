package com.epam;

public class ImplMessage implements Message {

	private String cryptedMessage;
	
	public ImplMessage() {
		
	}
	
	@Override
	public void load(String cryptedMessage) {
		this.cryptedMessage = cryptedMessage;
	}

	
	
	public void crypted() {

	}

	public void decryption() {

	}
	

}
