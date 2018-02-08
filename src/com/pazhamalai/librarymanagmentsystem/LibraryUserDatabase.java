package com.pazhamalai.librarymanagmentsystem;

import java.util.HashMap;

//should be used for storing list of books taken by student instead of list
import java.util.Set;

import java.util.ArrayList;

class LibraryUserDatabase {
	private static final HashMap<LibraryMemberAccess, MemberDetails> map = new HashMap<>();
	private static final HashMap<Book, BookDetails> bookMap = new HashMap<>();
	private static LibraryUserDatabase database = null;

	private LibraryUserDatabase() {

	}

	static LibraryUserDatabase getInstance() {
		if (database == null) {
			database = new LibraryUserDatabase();
		}
		return database;
	}

	private static class MemberDetails {
		private LibraryMemberAccess member;
		private ArrayList<Book> booksTaken = new ArrayList<>();
		private String name;
		private long userID;
		private int yearOfJoining;
		private String department;

		private MemberDetails(LibraryMemberAccess member) {
			this.member = member;
			this.name = member.getName();
			this.userID = member.getMemberID();
			this.yearOfJoining = member.getYearOfJoining();
			this.department = member.getDepartment();

		}

		private int getNumberOfBooksTaken() {
			return booksTaken.size();
		}

		private ArrayList<Book> getBooksTaken() {
			return booksTaken;
		}

		private LibraryMemberAccess getMember() {
			return member;
		}

		private String getName() {
			return name;
		}

		private long getUserID() {
			return userID;
		}

		private int getYearOfJoining() {
			return yearOfJoining;
		}

		private String getDepartment() {
			return department;
		}

	}

	private static class BookDetails {
		private String title;
		private String authours[];
		private int totalPages;
		private String genre;
		private long isbnNumber;
		private String typeOfCover;
		private LibraryMemberAccess holder = null;
		private static long numberOfBooks = 0;
		private long libraryCode;

		private BookDetails(Book book) {
			this.title = book.getTitle();
			this.authours = book.getAuthours();
			this.totalPages = book.getTotalPages();
			this.genre = book.getGenre();
			this.isbnNumber = book.getIsbnNumber();
			this.typeOfCover = book.getTypeOfCover();
			numberOfBooks++;
			this.libraryCode = numberOfBooks;
		}

		private static long getNumberOfBooks() {
			return numberOfBooks;
		}

		private long getLibraryCode() {
			return libraryCode;
		}

		private String[] getAuthours() {
			return authours;
		}

		private LibraryMemberAccess getHolder() {
			return holder;
		}

		private void setHolder(LibraryMemberAccess holder) {
			this.holder = holder;
		}

		private String getTitle() {
			return title;
		}

		private int getTotalPages() {
			return totalPages;
		}

		private String getGenre() {
			return genre;
		}

		private long getIsbnNumber() {
			return isbnNumber;
		}

		private String getTypeOfCover() {
			return typeOfCover;
		}

	}

	void checkAndAddThisUserToLibraryDatabase(LibraryMemberAccess member) {
		if (!map.containsKey(member)) {
			MemberDetails newUser = new MemberDetails(member);
			map.put(member, newUser);
			System.out.println(member.getName() + " was successfully added in the library");
		} else {
			System.err.println("User has got library access aldready");
		}
	}

	long addThisBookToLibraryDatabase(Book book) {
		BookDetails newBook = new BookDetails(book);
		bookMap.put(book, newBook);
		System.out.println(newBook.getTitle() + " was successfully added in library");
		return newBook.getLibraryCode();
	}

	boolean checkUserAndIssueBook(LibraryMemberAccess member, Book book) {
		if (checkUserWasInDatabase(member)) {
			if (checkBookWasInDatabase(book)) {
				if (checkUserHoldThisBook(member, book)) {
					if (checkBookHoldAnyUser(member, book)) {
						System.out.println(book.getTitle() + " was given to user " + member.getName());
						giveBookToUser(member, book);
						return true;
					}
				}
			}
		}
		return false;

	}

	boolean checkUserWasInDatabase(LibraryMemberAccess member) {
		if (map.containsKey(member)) {
			return true;
		} else {
			System.err.println("User was not in database, add user to database");
			return false;
		}
	}

	boolean checkBookWasInDatabase(Book book) {
		if (bookMap.containsKey(book)) {
			return true;
		} else {
			return false;
		}
	}

	boolean checkUserHoldThisBook(LibraryMemberAccess member, Book book) {
		MemberDetails libraryMember = map.get(member);
		ArrayList<Book> booksTaken = libraryMember.getBooksTaken();
		if (!booksTaken.contains(book)) {
			System.out.println("User does not hold this book");
			return true;
		} else {
			System.out.println("User had that book");
			return false;
		}
	}

	boolean checkBookHoldAnyUser(LibraryMemberAccess member, Book book) {
		BookDetails libraryBook = bookMap.get(book);
		if (libraryBook.getHolder() == null) {
			System.out.println("Book does not have any user");
			return true;
		} else {
			System.out.println("Book has user");
			return false;
		}
	}

	void checkUserAndRemoveBookFromUser(LibraryMemberAccess member, Book book) {
		if (checkUserWasInDatabase(member)) {
			if (checkBookWasInDatabase(book)) {
				if (!checkUserHoldThisBook(member, book)) {
					if (!checkBookHoldAnyUser(member, book)) {
						System.out.println(book.getTitle() + " was received from user " + member.getName());
						removeBookFromUser(member, book);
					}
				}
			}
		}
	}

	int getNumberOfBooksTaken(LibraryMemberAccess member) {
		return map.get(member).getNumberOfBooksTaken();
	}

	void getUserDetails(LibraryMemberAccess member) {
		if (map.containsKey(member)) {
			MemberDetails libraryUser = map.get(member);
			System.out.println(libraryUser.getName() + " " + libraryUser.getUserID() + " " + libraryUser.getDepartment()
					+ " " + libraryUser.getYearOfJoining() + " " + libraryUser.getNumberOfBooksTaken());
			ArrayList<Book> booksTaken = libraryUser.getBooksTaken();
			System.out.println(booksTaken);
		}
	}

	private void removeBookFromUser(LibraryMemberAccess member, Book book) {
		MemberDetails libraryMember = map.get(member);
		ArrayList<Book> booksTaken = libraryMember.getBooksTaken();
		booksTaken.remove(book);

		BookDetails libraryBook = bookMap.get(book);
		libraryBook.setHolder(null);
	}

	private void giveBookToUser(LibraryMemberAccess member, Book book) {

		MemberDetails bookTaker = map.get(member);
		ArrayList<Book> booksGiven = bookTaker.getBooksTaken();
		booksGiven.add(book);

		BookDetails issueBook = bookMap.get(book);
		issueBook.setHolder(member);
	}

}