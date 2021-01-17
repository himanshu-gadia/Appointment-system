package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.db.DbConnection;

public class AddApp2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pIdStr = request.getParameter("pId");
		String docIdStr = request.getParameter("docId");
		String dateStr = request.getParameter("appdate");
		String shiftStr = request.getParameter("appshift");
		// parsing
		int pId = Integer.parseInt(pIdStr);
		int dId = Integer.parseInt(docIdStr);
		Date utilDate = null;
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			System.out.println("Parse error " + e.getMessage());
		}
		Long time = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(time);
		
		int shiftTime;
		if(shiftStr.equals("morning")){
			shiftTime = 900;
		}else{
			shiftTime = 1400;
		}

		// jdbc code
		Connection con = null;
		PreparedStatement pstmt = null;
		String errors = null;
		String acknowledgementMsg = null;
		try {
			con = DbConnection.getConnection();
			String sql = "insert into Appointment_Table(REF_ID, P_ID, D_ID, A_DATE, A_TIME)values(Appointment_seq.nextVal,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pId);
			pstmt.setInt(2, dId);
			pstmt.setDate(3, sqlDate);
			pstmt.setInt(4, shiftTime);
			pstmt.executeUpdate();
			acknowledgementMsg = "Appointment booked Successfully. Please check appointment table to find it.";
		} catch (SQLException e) {
			errors = "Error occured with booking appointment.Please Try again!";
			 System.out.println(e.getMessage());
		}finally {
			try {
				DbConnection.closeConnection(con);
			} catch (Exception e) {
				errors = "DB errors" + e.getMessage();
				e.getStackTrace();
			}// catch
		}// finally

		if (errors != null) {
			request.setAttribute("acknowledgementMsg", acknowledgementMsg);
			RequestDispatcher rd = request.getRequestDispatcher("start.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errors", errors);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}// doPost

}// class
