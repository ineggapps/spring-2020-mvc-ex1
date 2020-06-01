package com.sp.note;

import java.util.List;

public class Note {
	private String userId;
	private String userName;

	private List<String> recipient;
	private String msg;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getRecipient() {
		return recipient;
	}

	public void setRecipient(List<String> recipient) {
		this.recipient = recipient;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}
