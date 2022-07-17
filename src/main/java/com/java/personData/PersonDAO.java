package com.java.personData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PersonDAO {
	Connection connection;
	PreparedStatement pst;
	public String insertData(Person person) throws ClassNotFoundException, SQLException
	{
		connection=ConnectionHelper.getConnection();
		String cmd="insert into person(id,personname,dob,gender) values(?,?,?,?)";
		pst=connection.prepareStatement(cmd);
//		Person person1=new Person();
		pst.setInt(1, person.getId());
		pst.setString(2, person.getPersonname());
		pst.setDate(3, person.getDob());
		pst.setString(4, person.getGender().toString());
		pst.executeUpdate();
		
		return "Inserted Successfully";
	}
	
	public List<Person> showPerson() throws ClassNotFoundException, SQLException
	{
		connection=ConnectionHelper.getConnection();
		String cmd="select * from person";
		pst=connection.prepareStatement(cmd);
		Person person=new Person();
		List<Person> arrList=new ArrayList<>();
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			person.setId(rs.getInt("id"));
			person.setPersonname(rs.getString("personname"));
			person.setDob(rs.getDate("dob"));
			person.setGender(Gender.valueOf(rs.getString("gender")));
			arrList.add(person);
			
		}
		return arrList;
		
	}
	
	public Person searchPerson(int id) throws ClassNotFoundException, SQLException
	{
		connection=ConnectionHelper.getConnection();
		String cmd="select * from person where id=?";
		pst=connection.prepareStatement(cmd);
		
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		Person ps=null;
		//List<Person> arrayList=new ArrayList<>();
		if(rs.next())
		{	ps=new Person();
			ps.setId(rs.getInt("id"));
			ps.setPersonname(rs.getString("personname"));
			ps.setDob(rs.getDate("dob"));
			ps.setGender(Gender.valueOf(rs.getString("gender")));
			//arrayList.add(ps);
			
		}
		return ps;
		
		
	}
	
	public String updateData(Person ps) throws ClassNotFoundException, SQLException
	{
		int id= ps.getId();
		Person found=searchPerson(id);
		if(found!=null)
		{
		connection=ConnectionHelper.getConnection();
		String Cmd="update person set personname=?, dob=?, gender=? where id=?";
//		String cmd="update employees set empname=?, begin_date=?, end_date=? where id=?";
		pst=connection.prepareStatement(Cmd);
//		Person ps=new Person();
	
		pst.setString(1, ps.getPersonname());
		pst.setDate(2, ps.getDob());
		pst.setString(3, ps.getGender().toString());
		pst.setInt(4, ps.getId());
		pst.executeUpdate();
		return "Update Suceesfully";
		}
		return "NOT FOUND";
	}
	
	public String deleteperson(int id) throws ClassNotFoundException, SQLException  {
			Person found=searchPerson(id);
			if(found!=null)
			{
			connection=ConnectionHelper.getConnection();
			String q="Delete from person where id=?";
			pst=connection.prepareStatement(q);
			pst.setInt(1, id);
			pst.executeUpdate();
			return "Dleted";
			}
			return "Not Found Record";
		
		
		
		
		
	}
}
