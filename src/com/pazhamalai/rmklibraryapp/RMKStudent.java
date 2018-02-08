package com.pazhamalai.rmklibraryapp;

import java.util.ArrayList;

import com.pazhamalai.librarymanagmentsystem.Book;
import com.pazhamalai.librarymanagmentsystem.Student;
import com.pazhamalai.librarymanagmentsystem.Librarian;

public class RMKStudent extends Student implements RMKLibraryAccess, RMKUserInformation {

	// List for storing books taken
	private ArrayList<RMKLibraryBook> booksTaken = new ArrayList<>();
	private static final RMKLibraryRegister STUDENT_REGISTER = new RMKLibraryRegister();

	public RMKStudent(String name, long rollNo, String department, int yearOfJoining) {
		super(name, rollNo, department, yearOfJoining, "RMK University");
	}

	public void addMeToLibraryDatabase(RMKLibrarian librarian) {
		librarian.addThisUserToDatabase(this);
	}

	public boolean getPermissionToEnter(RMKLibrarian librarian) {
		return librarian.givePermission(this);
	}

	public void takeBook(Book book, Librarian librarian) {
		if (((RMKLibrarian) librarian).issueBook(this, (RMKLibraryBook) book) != null) {
			booksTaken.add((RMKLibraryBook) book);
			STUDENT_REGISTER.writeIssueDetails(this.getName(), (long) this.getRollNo(), this.getDepartment(),
					book.getTitle(), ((RMKLibraryBook) book).getLibraryCode());
		}
	}

	public void returnBook(Book book, Librarian librarian) {
		if (((RMKLibrarian) librarian).receiveBook(this, (RMKLibraryBook) book)) {
			booksTaken.remove(book);
			STUDENT_REGISTER.writeReturnDetails(this.getName(), this.getRollNo(), this.getDepartment(), book.getTitle(),
					((RMKLibraryBook) book).getLibraryCode());
		}
	}

	public void payFine(Librarian librarian) {
		((RMKLibrarian) librarian).collectFine(this);
	}

	public RMKLibraryBook requestToAddBook(Book book, RMKLibrarian librarian) {
		return librarian.addBook(book);
	}

	public user getUserType() {
		return user.STUDENT;
	}

	public long getMemberID() {
		return getRollNo();
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
		return "RMKStudent [userType=" + getUserType() + ", booksTaken=" + booksTaken + ", hashCode()=" + hashCode()
				+ ", getName()=" + getName() + ", getRollNo()=" + getRollNo() + ", getDepartment()=" + getDepartment()
				+ ", getYearOfJoining()=" + getYearOfJoining() + ", getUniversity()=" + getUniversity()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";

	}
}
