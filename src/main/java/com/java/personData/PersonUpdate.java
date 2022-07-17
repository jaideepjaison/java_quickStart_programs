package com.java.personData;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PersonDAO dao=new PersonDAO();
		Date date=new Date();
		Scanner sc=new Scanner(System.in);
		Person ps=new Person();
		System.out.println("Enter ID To BE Update :");
		ps.setId(sc.nextInt());
		System.out.println("Name ");
		ps.setPersonname(sc.next());
		System.out.println("DOB ");
		String date1=sc.next();
		java.sql.Date sqldate=null;
		
		try {
			date=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			sqldate=new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ps.setDob(sqldate);
		
		System.out.println("Enter GEnder");
		String gen=sc.next();
		
		if(gen.toUpperCase().equals("MALE"))
		{
			ps.setGender(Gender.MALE);
		}
		if(gen.toUpperCase().equals("FEMALE"))
		{
			ps.setGender(Gender.FEMALE);
		}
		
		System.out.println(dao.updateData(ps));
	}
}
