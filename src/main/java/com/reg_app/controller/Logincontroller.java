     package com.reg_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reg_app.model.Dao;
import com.reg_app.model.Daoimpl;



@WebServlet("/loginverify")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Logincontroller() {
        super();
        
    }  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Dao ser=new Daoimpl();
		ser.connectDB();
		boolean status = ser.verify(email, password);
		if(status==true) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/createreg.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("error", "invalid");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
