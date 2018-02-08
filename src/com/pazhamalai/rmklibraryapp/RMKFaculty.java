package com.pazhamalai.rmklibraryapp;

import java.util.ArrayList;

import com.pazhamalai.librarymanagmentsystem.Book;
import com.pazhamalai.librarymanagmentsystem.Faculty;
import com.pazhamalai.librarymanagmentsystem.Librarian;

public class RMKFaculty extends Faculty implements RMKLibraryAccess, RMKUserInformation {

	private int userType;

	// List for storing books taken
	private ArrayList<RMKLibraryBook> booksTaken = new ArrayList<>();

	// Separate Library Register for Faculties
	private static final RMKLibraryRegister FACULTY_REGISTER = new RMKLibraryRegister();

	public RMKFaculty(String name, String department, short yearOfJoining, long employeeID) {
		super(name, department, yearOfJoining, employeeID, "RMK University");
		userType = RMKUserInformation.FACULTY_USER_TYPE;
	}

	public boolean getPermissionToEnter(RMKLibrarian librarian) {
		return librarian.givePermission(this);
	}

	public void takeBook(Book book, Librarian librarian) {
		if (((RMKLibrarian) librarian).issueBook(this, (RMKLibraryBook) book) != null) {
			booksTaken.add((RMKLibraryBook) book);
			FACULTY_REGISTER.writeIssueDetails(this.getName(), (long) this.getEmployeeID(), this.getDepartment(),
					book.getTitle(), ((RMKLibraryBook) book).getLibraryCode());
		}
	}

	public void returnBook(Book book, Librarian librarian) {
		if (((RMKLibrarian) librarian).receiveBook(this, (RMKLibraryBook) book)) {
			booksTaken.remove(book);
			FACULTY_REGISTER.writeReturnDetails(this.getName(), this.getEmployeeID(), this.getDepartment(),
					book.getTitle(), ((RMKLibraryBook) book).getLibraryCode());
		}
	}

	public void payFine(Librarian librarian) {
		((RMKLibrarian) librarian).collectFine(this);
	}

	public RMKLibraryBook requestToAddBook(Book book, RMKLibrarian librarian) {
		return librarian.addBook(book);
	}

	public int getUserType() {
		return userType;
	}

	public long getMemberID() {
		return getEmployeeID();
	}

	public void readMagazine() {
		System.out.println("Reading magazine");
	}

	public void readJournal() {
		System.out.println("Reading journal");
	}

	public void accessEJournal() {
		System.out.println("Reading E-Journal");
	}

	@Override
	public String toString() {
		return "RMKFaculty [userType=" + userType + ", booksTaken=" + booksTaken + ", getName()=" + getName()
				+ ", getDepartment()=" + getDepartment() + ", getYearOfJoining()=" + getYearOfJoining()
				+ ", getEmployeeID()=" + getEmployeeID() + ", getUniversity()=" + getUniversity() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
