package com.reg_app.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reg_app.model.Dao;
import com.reg_app.model.Daoimpl;


@WebServlet("/delete")
public class Deleteregis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Deleteregis() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null){
		
		
		
		String email = request.getParameter("emailID");
		
		Dao ser=new Daoimpl();
		ser.connectDB();
		ser.deletereg( email);
		ResultSet result = ser.listallreg();
		request.setAttribute("result", result);
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listreg.jsp");
		rd.forward(request, response);
		
		
		
		
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
