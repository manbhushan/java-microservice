package com.reg_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Daoimpl implements Dao {
	Connection con;
	Statement st;

	@Override
	public void connectDB() {
		 try {
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationapp","root","w0r1dwea1th");
			st=con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean verify(String email, String password) {
		try {
			ResultSet set = st.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return set.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void savereg(String name, String city, String email, String mobile) {
		try {
			 st.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listallreg() {
		
		try {
			ResultSet result = st.executeQuery("select * from registration");
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void deletereg(String email) {
		try {
			 st.executeUpdate("Delete from registration where email='"+email+"'");
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatereg(String email, String mobile) {
		try {
			 st.executeUpdate("UPDATE registration SET mobile = '"+mobile+"' WHERE email='"+email+"'");
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
}
