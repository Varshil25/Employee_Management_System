package com.demo.EmployeeUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDB {
	Configuration cfg;
	SessionFactory sf;
	static Session session;
	public EmployeeDB() {
		cfg = new Configuration();
		cfg.configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
	}

	public void addEmployee(Employee emp) {
		Transaction t = session.beginTransaction();
		session.save(emp);
		t.commit();
		System.out.println("Employee Details are stored Successfully");
	}
	
	public List<Employee> dispEmployee() {
		List<Employee> li = new ArrayList<>();
		li = session.createQuery("FROM Employee").list();
		return li;
	}
	
	public void updateEmployee(int empid) {
		Scanner sc = new Scanner(System.in);
		session.beginTransaction();
		Employee emp = (Employee)session.get(Employee.class, empid);
		System.out.println("Enter Name to Update :");
		String n = sc.next();
		System.out.println("Enter Salary to Update :");
		double s = sc.nextDouble();
		
		emp.setName(n);
		emp.setSalary(s);
		session.getTransaction().commit();
		System.out.println("Employee ID :" + empid+ "is Updated Successfully");
	}
	
	public static Employee findRecordById(int empid) {
		Employee emprecord = null;
		session.beginTransaction();
		emprecord = session.load(Employee.class, empid);
		return emprecord;
	}
	
	public void deleteEmployee(int empid) {

		Employee em = findRecordById(empid);
		session.delete(em);
		System.out.println("employee ID" + empid+ "is delete Successfully");
	}

}
