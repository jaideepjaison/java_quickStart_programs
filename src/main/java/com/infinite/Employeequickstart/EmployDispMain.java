package com.infinite.Employeequickstart;

import java.sql.SQLException;
import java.util.List;

public class EmployDispMain {
public static void main(String[] args) {
	EmployeeDAO dao=new EmployeeDAO();
	try {
		List<Employ> arrEmploy=dao.showEmploy();
		for(Employ emp :arrEmploy)
		{
			System.out.println(emp);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
