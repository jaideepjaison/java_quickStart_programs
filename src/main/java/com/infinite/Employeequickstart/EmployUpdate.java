package com.infinite.Employeequickstart;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDAO dao=new EmployeeDAO();
		Scanner sc=new Scanner(System.in);
		Employ emp=new Employ();
		System.out.println("Enter ID");
		emp.setId(sc.nextInt());
		System.out.println("Enter Employ Name");
		emp.setEmpname(sc.next());
		System.out.println("Enter Begin Date");
		emp.setBegin_date(sc.next());
		System.out.println("Enter End Date");
		emp.setEnd_date(sc.next());
		String updateDetails= dao.updateDetails(emp);
		System.out.println(updateDetails);
		
	}
}
