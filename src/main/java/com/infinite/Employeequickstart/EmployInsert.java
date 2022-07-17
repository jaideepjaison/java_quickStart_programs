package com.infinite.Employeequickstart;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployInsert {
	
	public static void main(String[] args) {
		EmployeeDAO dao=new EmployeeDAO();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID");
		int id=sc.nextInt();
		System.out.println("Enter Employ Name");
		String empname=sc.next();
		System.out.println("Enter Begin Date");
		String begindate=sc.next();
		System.out.println("Enter End Date");
		String enddate=sc.next();
		
		try {
			Employ addDetails=dao.addDetailsEmploy(id, empname, begindate, enddate);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
