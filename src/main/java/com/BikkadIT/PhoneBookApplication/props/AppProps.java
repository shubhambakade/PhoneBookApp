package com.BikkadIT.PhoneBookApplication.props;

import java.util.HashMap;
import java.util.Map;

public class AppProps {

	private Map<String,String> messages=new HashMap<String,String>();

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
}
