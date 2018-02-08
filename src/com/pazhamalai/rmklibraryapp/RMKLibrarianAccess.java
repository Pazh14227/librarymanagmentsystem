package com.pazhamalai.rmklibraryapp;

import com.pazhamalai.librarymanagmentsystem.Book;
import com.pazhamalai.librarymanagmentsystem.LibraryMemberAccess;

interface RMKLibrarianAccess {

	boolean givePermission(LibraryMemberAccess member);

	RMKLibraryBook addBook(Book book);

	Book issueBook(LibraryMemberAccess member, RMKLibraryBook book);

	boolean receiveBook(LibraryMemberAccess member, RMKLibraryBook book);

	void collectFine(LibraryMemberAccess member);

	void addThisUserToDatabase(LibraryMemberAccess member);
}