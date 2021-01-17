package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameters 
		String nameStr = request.getParameter("name");
		String usernameStr = request.getParameter("username");
		String passwordStr = request.getParameter("password");
		String roleTypeStr = request.getParameter("roletype");
		
		// no need for 
		
	}

}
