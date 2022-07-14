package com.subin.entity;

public class Employee {
	
	private Integer employeeId;
	private String employeeName;
	private String employeeContactNumber;
	private String employeeEmailId;
	private Integer employeeAge;
	private String employeeGender;
	private Integer hotelId;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeContactNumber() {
		return employeeContactNumber;
	}
	public void setEmployeeContactNumber(String employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
	}
	public String getEmployeeEmailId() {
		return employeeEmailId;
	}
	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}
	public Integer getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeContactNumber="
				+ employeeContactNumber + ", employeeEmailId=" + employeeEmailId + ", employeeAge=" + employeeAge
				+ ", employeeGender=" + employeeGender + ", hotelId=" + hotelId + "]";
	}
	

}
