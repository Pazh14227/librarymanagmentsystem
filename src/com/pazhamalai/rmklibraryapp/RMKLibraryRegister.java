package com.pazhamalai.rmklibraryapp;

public class RMKLibraryRegister {
	private byte indexLimit = 20;
	private byte pageLimit = 100;
	private byte index = 0;
	private byte page = 0;
	private String name[][] = new String[pageLimit][indexLimit];
	private long rollNumberOrEmployeeID[][] = new long[pageLimit][indexLimit];
	private String department[][] = new String[pageLimit][indexLimit];
	private String bookTitle[][] = new String[pageLimit][indexLimit];
	private long libraryCode[][] = new long[pageLimit][indexLimit];

	void writeIssueDetails(String name, long rollNumber, String department, String title, long libraryCode) {
		this.name[page][index] = name;
		this.rollNumberOrEmployeeID[page][index] = rollNumber;
		this.department[page][index] = department;
		this.bookTitle[page][index] = title;
		this.libraryCode[page][index] = libraryCode;
		index++;
		if (index == 20) {
			index = 0;
			page++;
		}
	}

	void writeReturnDetails(String name, long rollNumber, String department, String title, long libraryCode) {
		this.name[page][index] = name;
		this.rollNumberOrEmployeeID[page][index] = rollNumber;
		this.department[page][index] = department;
		this.bookTitle[page][index] = title;
		this.libraryCode[page][index] = libraryCode;
		index++;
		if (index == 20) {
			index = 0;
			page++;
		}
	}

}
