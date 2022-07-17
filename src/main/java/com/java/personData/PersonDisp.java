package com.java.personData;

import java.sql.SQLException;

public class PersonDisp {
	public static void main(String[] args) {
		PersonDAO dao=new PersonDAO();
		
		try {
			System.out.println(dao.showPerson());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
