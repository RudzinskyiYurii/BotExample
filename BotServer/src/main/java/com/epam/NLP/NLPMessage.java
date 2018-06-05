package com.epam.NLP;

import java.util.List;

public interface NLPMessage {
	public void load(String message);
	public List<String> result();
}
