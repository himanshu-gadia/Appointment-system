package com.bo;

import java.sql.Date;

public class AppointmentInfo {
	private int id;
	private int patientId;
	private int doctorId;
	private Date appointmentDate;
	private int timing;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public int getTiming() {
		return timing;
	}
	public void setTiming(int timing) {
		this.timing = timing;
	}
	
}
