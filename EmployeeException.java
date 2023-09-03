package com.demo.EmployeeUI;

public class EmployeeException extends Exception {

	private String msg;
	
	public EmployeeException() {
		msg = " Error Occured";
	}
	
	public EmployeeException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
	public String toString() {
		return "Employee Exception : " + msg;
	}
}
