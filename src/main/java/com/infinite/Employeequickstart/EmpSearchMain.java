package com.infinite.Employeequickstart;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmpSearchMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDAO dao=new EmployeeDAO();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID to Be Searched");
		int id=sc.nextInt();
		Employ arry=dao.searchEmploy(id);
			
			if(arry!=null)
			{
			System.out.println(arry);
			}
			else
			{
				System.out.println("Not found");
			}
		
	}
}
