package com.reg_app.model;

import java.sql.ResultSet;

public interface Dao {
	public void connectDB();
	public boolean verify(String email,String password);
	public void savereg(String name,String city,String email,String mobile);
	public ResultSet listallreg();
	public void deletereg(String email);
	public void updatereg(String email, String mobile);
}
