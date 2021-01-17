package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AppointmentInfo;
import com.bo.Doctor;
import com.util.db.DbConnection;

public class ListOpenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get data
		String idStr = request.getParameter("docid");
		int id = Integer.parseInt(idStr);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String errors = null;
		AppointmentInfo appInfo = null;
		Doctor dObj = new Doctor();
		dObj.setId(id);
		ArrayList<AppointmentInfo> arrList = new ArrayList<AppointmentInfo>();
		try {
			con = DbConnection.getConnection();
			String sql = "select * from appointment_table where d_id = ? and a_date> sysdate";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			//extracting the result
			while(rs.next()){
				int appId = rs.getInt("ref_id");
				int pId = rs.getInt("p_id");
				int dId = rs.getInt("d_id");
				Date appDate = rs.getDate("a_date");
				int appTime = rs.getInt("a_time");
				
				appInfo = new AppointmentInfo();
				appInfo.setId(appId);
				appInfo.setPatientId(pId);
				appInfo.setDoctorId(dId);
				appInfo.setAppointmentDate(appDate);
				appInfo.setTiming(appTime);
				
				arrList.add(appInfo);
				System.out.println("executed.....");
			}
		} catch (SQLException e) {
			errors = "Id entered is not present. Please enter a valid one.";
			System.out.println(e.getMessage());
		}catch (Exception e) {
			errors = "Error. Please try again.";
		}finally{
			try {
				DbConnection.closeConnection(con);
				System.out.println("connection closed");
			} catch (SQLException e2) {
				errors = "error while closing DB connection";
			}catch (Exception e2) {
				errors = "error while closing.";
			}
		}//finally
		if(arrList!=null){
			request.setAttribute("dObj", dObj);
			request.setAttribute("arrList", arrList);
			System.out.println("request dispatched 2");
			RequestDispatcher rd = request.getRequestDispatcher("ApptTable2.jsp");
			System.out.println("request dispatched 3");
			rd.forward(request, response);
			System.out.println("request dispatched");
		}else{
			request.setAttribute("errors", errors);
			RequestDispatcher rd = request.getRequestDispatcher("ApptTable.jsp");
			rd.forward(request, response);
		}
	}//doPost

}
