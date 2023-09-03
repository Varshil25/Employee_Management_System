package com.demo.EmployeeUI;

import java.util.regex.Pattern;

public class EmployeeValidate {
	
	public static boolean validateEmpid(String id) throws EmployeeException{
		String pattern = "\\d{1,3}";
		if(Pattern.matches(pattern, id)) {
			return true;
		}else {
			throw new EmployeeException("Employee Id should be in digits");
		}
	}
	
	public static boolean validateEmpName(String name) throws EmployeeException{
		String pattern = "^[a-zA-Z]+${6,15}";
		if(Pattern.matches(pattern , name)) {
			return true;
		}else {
			throw new EmployeeException("Employee Name should be in Character");
		}
	}
	
	public static boolean validateEmpSalary(String salary) throws EmployeeException{
		String pattern = "\\d{3,10}";
		if(Pattern.matches(pattern , salary)) {
			return true;
		}else {
			throw new EmployeeException("Employee slaray should be in digits.");
		}
	}

}
