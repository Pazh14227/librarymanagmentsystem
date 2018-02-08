package com.pazhamalai.librarymanagmentsystem;

public class Faculty {
	private String name;
	private String department;
	private int yearOfJoining;
	private long employeeID;
	private String university;

	public Faculty(String name, String department, short yearOfJoining, long employeeID, String university) {
		this.name = name;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.employeeID = employeeID;
		this.university = university;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public String getUniversity() {
		return university;
	}

}
