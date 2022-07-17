package com.java.personData;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PersonInsertMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Date date=new Date();
		PersonDAO dao=new PersonDAO();
		Scanner sc=new Scanner(System.in);
		Person person=new Person();
		System.out.println("Enter ID");
		person.setId(sc.nextInt());
		System.out.println("Enter Person Name");
		person.setPersonname(sc.next());
		System.out.println("Enter DOb");
		String date1=sc.next();
		java.sql.Date sqldate= null;
		
		try {
			date= new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			sqldate=new java.sql.Date(date.getTime());
			//System.out.println(sqldate);
			person.setDob(sqldate);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Enter Gender");
		String gen=sc.next();
		if(gen.toUpperCase().equals("MALE"))
		{
			person.setGender(Gender.MALE);
		}
		if(gen.toUpperCase().equals("FEMALE"))
		{
			person.setGender(Gender.FEMALE);
		}
		System.out.println(dao.insertData(person));
	}
}
