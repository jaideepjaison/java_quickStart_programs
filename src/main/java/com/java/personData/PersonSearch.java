package com.java.personData;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PersonSearch {
	public static void main(String[] args) {
		PersonDAO dao=new PersonDAO();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID to Be Searched");
		int id=sc.nextInt();
		
		try {
			Person ps=dao.searchPerson(id);
			if(ps!=null)
			{
			System.out.println(ps);
			}
			else
			{
				System.out.println("NOT FOUND");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
