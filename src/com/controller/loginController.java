package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.User;
import com.util.db.DbConnection;

public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginIdStr = request.getParameter("login_id");
		String loginPasswordStr = request.getParameter("login_password");
		// no need to do parsing

		// validate into db and do jdbc code
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		String errors = null;
		try {
			con = DbConnection.getConnection();
			String sql = "select * from hospital_login where username = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginIdStr);
			pstmt.setString(2, loginPasswordStr);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int idInt = rs.getInt("id");
				String nameStr = rs.getString("name");
				String roleTypeStr = rs.getString("rolltype");

				user = new User();
				user.setId(idInt);
				user.setName(nameStr);
				user.setRollType(roleTypeStr);
				user.setUsername(loginIdStr);
				user.setUserPassword(loginPasswordStr);
			}// if
		} catch (SQLException e) {
			errors = "DB error" + e.getMessage();
		} catch (Exception e) {
			errors = "error" + e.getMessage();
		} finally {
			try {
				DbConnection.closeConnection(con);
			} catch (SQLException e) {
				errors = "Db error" + e.getMessage();
				e.printStackTrace();
			}
		}

		// create a session
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
				response.sendRedirect("start.jsp");
		} else {
			if (errors == null && user == null) { // errors condn bcoz if no
													// error means issue is with
													// user
				errors = "Invalid user or password";
			}
			//send errors
			request.setAttribute("errors", errors);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
