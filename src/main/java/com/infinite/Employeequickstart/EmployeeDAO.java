package com.infinite.Employeequickstart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	Connection connection;
	PreparedStatement pst;
	
	public List<Employ> showEmploy() throws ClassNotFoundException, SQLException{
		connection=ConnectionHelper.getConnection();
		String cmd="select * from employees";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		List<Employ> emplist=new ArrayList<Employ>();
		Employ emp =null;
		while(rs.next())
		{
			emp=new Employ();
			emp.setId(rs.getInt("id"));
			emp.setEmpname(rs.getString("empname"));
			emp.setBegin_date(rs.getString("begin_date"));
			emp.setEnd_date(rs.getString("end_date"));
			emplist.add(emp);
		}
		return emplist;
	}
	
	public Employ searchEmploy(int id) throws SQLException, ClassNotFoundException {
		connection=ConnectionHelper.getConnection();
		String cmd="select * from employees where id=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
//		List<Employ> empList=new ArrayList<Employ>();
		Employ emp=null;
		while(rs.next())
		{
			emp=new Employ();
			emp.setId(rs.getInt("id"));
			emp.setEmpname(rs.getString("empname"));
			emp.setBegin_date(rs.getString("begin_date"));
			emp.setEnd_date(rs.getString("end_date"));
//			empList.add(emp);
			
		}
		return emp;
		
		
	}
	
	public Employ addDetailsEmploy(int id, String empname,String begin_date,String end_date) throws ClassNotFoundException, SQLException
	{
		connection=ConnectionHelper.getConnection();
		String Cmd="Insert into employees(id, empname, begin_date, end_date) values (?,?,?,?)";
		pst=connection.prepareStatement(Cmd);
		pst.setInt(1, id);
		pst.setString(2, empname);
		pst.setString(3, begin_date);
		pst.setString(4, end_date);
		pst.executeUpdate();
		return null;
	}
	
	public String updateDetails(Employ employ) throws ClassNotFoundException, SQLException
	{
		connection=ConnectionHelper.getConnection();
		String cmd="update employees set empname=?, begin_date=?, end_date=? where id=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(4, employ.getId());
		pst.setString(1, employ.getEmpname());
		pst.setString(2, employ.getBegin_date());
		pst.setString(3, employ.getEnd_date());
		pst.executeUpdate();
		return "Record Update";
		
	}
	
}
