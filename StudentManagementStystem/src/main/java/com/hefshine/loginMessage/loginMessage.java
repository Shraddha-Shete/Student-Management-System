package com.hefshine.loginMessage;

public class loginMessage {
	
	String message;
	boolean status;
	public loginMessage() {
		
	}
	public loginMessage(String message, boolean status) {
		
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "loginMessage [message=" + message + ", status=" + status + "]";
	}
	
	

}
