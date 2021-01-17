package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Doctor;
import com.bo.Patient;
import com.util.db.DbConnection;


public class AddApp1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pIdStr = request.getParameter("pId");
		String deptStr = request.getParameter("dept");
		//parsing
		int pId = Integer.parseInt(pIdStr);
		//jdbc code 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 Doctor docObj = null;
		String errors = null;
		Patient patientObj = new Patient();
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		patientObj.setId(pId);
		try {
			con = DbConnection.getConnection();
			String sql = "select id,name,designation from Doctors_record where specialisation = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deptStr);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				//fetch if result available
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				//set in the user object 
				docObj = new Doctor();
				docObj.setId(id);
				docObj.setName(name);
				docObj.setDesignation(designation);
				doctorList.add(docObj);
			}
		}catch(SQLException e){
			errors = "DB error" + e.getMessage();
		}catch (Exception e) {
			errors = "error" + e.getMessage();			
		}finally{
			try {
				DbConnection.closeConnection(con);
			} catch (Exception e) {
				errors = "DB errors"+ e.getMessage();
				e.getStackTrace();
			}//catch	
	}//finally 
		if(docObj!=null){
			request.setAttribute("doctorList", doctorList);
			request.setAttribute("patientObj", patientObj);
			RequestDispatcher rd = request.getRequestDispatcher("AddApp2.jsp");
			rd.forward(request, response);
		}else{
			if(errors == null && docObj == null){
				errors = "No doctor is found in that department. please enter again";
			}
			request.setAttribute("errors", errors);
			//string name then object in setAttribute
			
			RequestDispatcher rd = request.getRequestDispatcher("AddApp1.jsp");
			rd.forward(request, response);
		}
		
		
	}//doPost

}
