package com.san.model;

public class Reservation {
	private String guestName;
	private String ReservationDate;
	private String ReservationTime;
	private String phoneNo;
	private String Email;
	private String occasion;
	private int guestSize;
	private int ConfirmationCode;
	private int tableNo;
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getReservationDate() {
		return ReservationDate;
	}
	public void setReservationDate(String ReservationDate) {
	this.ReservationDate = ReservationDate;
	}
	public String getReservationTime() {
		return ReservationTime;
	}
	public void setReservationTime(String reservationTime) {
		ReservationTime = reservationTime;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	public int getGuestSize() {
		return guestSize;
	}
	public void setGuestSize(int guestSize) {
		this.guestSize = guestSize;
	}
	public int getConfirmationCode() {
		return ConfirmationCode;
	}
	public void setConfirmationCode(int confirmationCode) {
		ConfirmationCode = confirmationCode;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	@Override
	public String toString() {
		return "Reservation [guestName=" + guestName + ", ReservationDate="
				+ ReservationDate + ", ReservationTime=" + ReservationTime
				+ ", phoneNo=" + phoneNo + ", Email=" + Email + ", occasion="
				+ occasion + ", guestSize=" + guestSize + ", ConfirmationCode="
				+ ConfirmationCode + ", tableNo=" + tableNo + "]";
	}
	

}
