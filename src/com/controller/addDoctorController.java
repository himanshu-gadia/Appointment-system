package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.db.DbConnection;

public class addDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regdNoStr = request.getParameter("id");
		String name = request.getParameter("name");
		String contactStr = request.getParameter("Contact");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String specialization = request.getParameter("specialization");
		String designation = request.getParameter("Designation");
		
		Long contactNum = Long.parseLong(contactStr);
		java.util.Date utilDateFormat = null;
		
		try {
			utilDateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		} catch (Exception e) {
			System.out.println("issue with util date" + e.getMessage());
		}
		Long time = utilDateFormat.getTime();
		Date sqlDate = new Date(time);
		
		// do tje jdbc code and validation part
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DbConnection.getConnection();
			String sql = "insert into Doctors_record(ID,REGD_NO,NAME,CONTACT,GENDER, DOB, SPECIALISATION, DESIGNATION)values(Doctors_id_seq.nextval , ?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, regdNoStr);
			pstmt.setString(2, name);
			pstmt.setLong(3, contactNum);
			pstmt.setString(4, gender);
			pstmt.setDate(5, sqlDate);
			pstmt.setString(6, specialization);
			pstmt.setString(7, designation);
			pstmt.executeUpdate();
			System.out.println("run successfully");
		} catch (SQLException e) {
			System.out.println("DB error" + e.getMessage());
		}catch (Exception e) {
			System.out.println("error" + e.getMessage());
		}finally{
			try {
				DbConnection.closeConnection(con);
			} catch (SQLException e) {
				System.out.println("problem with closing connection" + e.getMessage());
				e.printStackTrace();	
			}
		}//finally
		
	}//doPost

}//servlet class
