package com.reg_app.controller;


import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reg_app.model.Dao;
import com.reg_app.model.Daoimpl;


@WebServlet("/listall")
public class listreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public listreg() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao ser=new Daoimpl();
		ser.connectDB();
		ResultSet result = ser.listallreg();
		request.setAttribute("result", result);
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listreg.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
