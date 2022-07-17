package com.infinite.Employeequickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.cj.protocol.Resultset;

public class EmpSearch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Name");
		String ename=sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");
			String cmd="select * from employees where empname=?";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(1, ename);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println("ID is "+rs.getInt("id"));
				System.out.println("Name is "+rs.getString("empname"));
				System.out.println("Begin Date is "+rs.getString("begin_date"));
				System.out.println("End Date is "+rs.getString("end_date"));
				System.out.println("-------------------");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
