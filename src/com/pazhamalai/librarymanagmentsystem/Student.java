package com.pazhamalai.librarymanagmentsystem;

public class Student {

	private String name;
	private long rollNumber;
	private String department;
	private int yearOfJoining;
	private String university;

	public Student(String name, long rollNo, String department, int yearOfJoining, String university) {
		this.name = name;
		this.rollNumber = rollNo;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.university = university;
	}

	public String getName() {
		return name;
	}

	public long getRollNo() {
		return rollNumber;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public String getUniversity() {
		return university;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (rollNumber ^ (rollNumber >>> 32));
		result = prime * result + ((university == null) ? 0 : university.hashCode());
		result = prime * result + yearOfJoining;
		return result;
	}

}
