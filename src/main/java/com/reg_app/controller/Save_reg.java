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


@WebServlet("/savereg")
public class Save_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Save_reg() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/createreg.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null){
		
		
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		
		Dao ser=new Daoimpl();
		ser.connectDB();
		ser.savereg(name, city, email, mobile);
		
		request.setAttribute("msg", "successfull");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/createreg.jsp");
		rd.forward(request, response);
		
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	
	}
	
	}
	

}
