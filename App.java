package com.demo.EmployeeUI;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int ch;
		String id, nm, sl;
		EmployeeDB edb = new EmployeeDB();
		
		while (true) {

			System.out.println("----------ABC---------");
			System.out.println("1. Adding an Employee");
			System.out.println("2. Displaying ALL Employee");
			System.out.println("3. Update an Employee");
			System.out.println("4. Delete an Employee");
			System.out.println("5. Exit the Application");
			System.out.println("Enter Your Choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				try {
					System.out.println("Enter EmpID :");
					id = sc.next();

					if (EmployeeValidate.validateEmpid(id)) {
						System.out.println("Enter EmpName :");
						nm = sc.next();
						if (EmployeeValidate.validateEmpName(nm)) {
							System.out.println("Enter Salary");
							sl = sc.next();
							if (EmployeeValidate.validateEmpSalary(sl)) {
								Employee emp = new Employee();
								emp.setEmpid(Integer.parseInt(id));
								emp.setName(nm);
								emp.setSalary(Double.parseDouble(sl));
								
								edb.addEmployee(emp);
							}
						}
					}
				} catch (EmployeeException ex) {
					System.err.println(ex);

				}

				break;
			case 2:
				ArrayList<Employee> e = new ArrayList<>();
				e = (ArrayList<Employee>) edb.dispEmployee();
				System.out.println("EmpId\tName\tsalary");
				for(int i = 0 ; i<e.size(); i++) {
					Employee e1 = e.get(i);
					System.out.println(e1.getEmpid()+"\t"+e1.getName()+"\t"+e1.getSalary());
				}
				break;
			case 3:
				System.out.println("Enter EmployeeID Which needs to be updated :");
				int i = sc.nextInt();
				edb.updateEmployee(i);
				break;
			case 4:
				System.out.println("Enter Employee ID to be deleted :");
				int eid = sc.nextInt();
				edb.deleteEmployee(eid);
				break;
			case 5:
				System.exit(1);
				break;
			default:
				System.err.println("Invalid Selection");
			}
		}
	}
}
