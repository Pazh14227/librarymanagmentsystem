package com.pazhamalai.librarymanagmentsystem;

public abstract class Librarian extends Faculty {
	private static final LibraryUserDatabase DATABASE = LibraryUserDatabase.getInstance();

	public Librarian(String name, short yearOfJoining, long employeeID, String university) {
		super(name, "Library", yearOfJoining, employeeID, university);
	}

	protected Book issueBook(LibraryMemberAccess member, Book book) {
		if (DATABASE.checkUserAndIssueBook(member, book)) {
			return book;
		}
		return null;
	}

	protected boolean receiveBook(LibraryMemberAccess member, Book book) {
		DATABASE.checkUserAndRemoveBookFromUser(member, book);
		return true;
	}

	// Have to predict fine amount by using data and time api in java and store it
	// in database
	protected void collectFine(LibraryMemberAccess member) {
		System.out.println("Fine collected from member " + member.getName());
	}

	protected long addNewBookToLibrary(Book book) {
		return DATABASE.addThisBookToLibraryDatabase(book);
	}

	protected void addThisMemberToLibrary(LibraryMemberAccess member) {
		DATABASE.checkAndAddThisUserToLibraryDatabase(member);
	}

	protected int getNumberOfBooksTakenByMember(LibraryMemberAccess member) {
		return DATABASE.getNumberOfBooksTaken(member);
	}

	protected boolean checkUserWasInLibraryDatabase(LibraryMemberAccess member) {
		return DATABASE.checkUserWasInDatabase(member);
	}

	protected boolean checkThisBookCanBeAddedToLibraryDatabase(Book book) {
		return !(DATABASE.checkBookWasInDatabase(book));
	}

}
