package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.db.DbConnection;

public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// no doGet as we dont have anything to send back to page
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get parameter

		String pNameStr = request.getParameter("name");
		String pFatherNameStr = request.getParameter("father_name");
		String contact = request.getParameter("contact");
		String secContact = request.getParameter("sec_contact");
		String pDob = request.getParameter("dob");
		String pGender = request.getParameter("gender");
		String pEmail = request.getParameter("email");
		String pPinCode = request.getParameter("pincode");
		System.out.println(pDob);
		long contactNum = Long.parseLong(contact);
		long secContactNum = Long.parseLong(secContact);
		int pincodeNum = Integer.parseInt(pPinCode);
		java.util.Date dobDateFormat = null;
		try {
			dobDateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(pDob);

		} catch (ParseException e) {
			System.out.println("parse exception" + e.getMessage());
		}
		// validate into jdbc and do the jdbc code
		Date dateSqlFormat = new Date(dobDateFormat.getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.getConnection();
			String sql = "insert into Patients_record(ID, NAME ,FATHER_NAME,CONTACT,CONTACT_SEC,DOB,GENDER, EMAIL,PINCODE ) values ( patients_id_seq.nextval, ? , ? , ?, ?, ?, ? , ? , ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pNameStr);
			pstmt.setString(2, pFatherNameStr);
			pstmt.setLong(3, contactNum);
			pstmt.setLong(4, secContactNum);
			pstmt.setDate(5, dateSqlFormat);
			pstmt.setString(6, pGender);
			pstmt.setString(7, pEmail);
			pstmt.setInt(8, pincodeNum);
			pstmt.executeUpdate();

			System.out.println("run successfully");
		} catch (SQLException e) {
			System.out.println("database error" + e.getMessage());
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
		} finally {
			try {
				DbConnection.closeConnection(con);
			} catch (SQLException e) {
				System.out.println("Databse error" + e.getMessage());
				e.printStackTrace();
			}
		}// finally

	}// doPost
}// class
