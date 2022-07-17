package com.java.personData;

import java.sql.SQLException;
import java.util.Scanner;

public class PersonDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PersonDAO dao=new PersonDAO();
		Person ps=new Person();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enetr ID");
		int id= sc.nextInt();
		
		String data= dao.deleteperson(id);
		
		if(data!=null)
		{
			System.out.println(data);
		}
		
	}
}
