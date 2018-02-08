package com.pazhamalai.rmklibraryapp;

import com.pazhamalai.librarymanagmentsystem.Book;
import com.pazhamalai.librarymanagmentsystem.Librarian;
import com.pazhamalai.librarymanagmentsystem.LibraryMemberAccess;

public class RMKLibrarian extends Librarian implements RMKLibrarianAccess {

	public RMKLibrarian(String name, short yearOfJoining, long employeeID) {
		super(name, yearOfJoining, employeeID, "RMK University");
	}

	// adding new user to library database.
	public void addThisUserToDatabase(LibraryMemberAccess member) {
		if (!(super.checkUserWasInLibraryDatabase(member))) {
			super.addThisMemberToLibrary(member);
		} else {
			System.err.println("User was aldready in database");
		}
	}

	// Verifying at the entry level
	public boolean givePermission(LibraryMemberAccess member) {
		if (member.getUniversity() == "RMK University") {
			return super.checkUserWasInLibraryDatabase(member);
		} else {
			System.err.println("You are not allowed to enter library");
			return false;
		}
	}

	// add new books to library
	public RMKLibraryBook addBook(Book book) {
		if (!(book instanceof RMKLibraryBook)) {
			if (super.checkThisBookCanBeAddedToLibraryDatabase(book)) {
				RMKLibraryBook newBook = new RMKLibraryBook(book);
				newBook.setLibraryCode(super.addNewBookToLibrary(newBook));
				return newBook;
			} else {
				return null;
			}
		} else {
			System.err.println("book was aldready in library");
			return null;
		}

	}

	public RMKLibraryBook issueBook(LibraryMemberAccess member, RMKLibraryBook book) {
		if (super.checkUserWasInLibraryDatabase(member)) {
			if (RMKStandards.checkLimitOfUser(member, super.getNumberOfBooksTakenByMember(member))) {
				return (RMKLibraryBook) (super.issueBook(member, book));
			} else {
				System.err.println("User have reached limit");
				return null;
			}
		} else {
			System.err.println("User was not in database");
			return null;
		}
	}

	public boolean receiveBook(LibraryMemberAccess member, RMKLibraryBook book) {
		return super.receiveBook(member, book);
	}

	// called super method to set or unset the amount to be paid by the user.
	public void collectFine(LibraryMemberAccess member) {
		super.collectFine(member);
	}

}
