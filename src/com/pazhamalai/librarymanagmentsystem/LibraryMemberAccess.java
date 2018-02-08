package com.pazhamalai.librarymanagmentsystem;

public interface LibraryMemberAccess {
	void takeBook(Book book, Librarian librarian);

	void returnBook(Book book, Librarian librarian);

	void payFine(Librarian librarian);

	String getName();

	String getDepartment();

	int getYearOfJoining();

	long getMemberID();

	String getUniversity();
}
