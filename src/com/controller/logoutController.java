package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); // fetching old session
		// if present
		// otherwise a new
		// session
		StringBuilder msg = new StringBuilder();
		if (session != null) {
			session.invalidate();
			msg.append("logout successfully");
		} else {
			msg.append("session already expired");
		}
		request.setAttribute("message", msg);
		RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
		rd.forward(request, response);
	}

}
