package com.pazhamalai.rmklibraryapp;

import com.pazhamalai.librarymanagmentsystem.Book;

public class RMKLibraryBook extends Book {
	private long libraryCode;

	// User for storing holder information
	private RMKUserInformation holder;

	public RMKLibraryBook(Book book) {
		super(book.getTitle(), book.getAuthours(), book.getIsbnNumber(), book.getGenre(), book.getTotalPages(),
				book.getTypeOfCover());
	}

	// book code is generated in database.
	public void setLibraryCode(long libraryCode) {
		this.libraryCode = libraryCode;
	}

	public long getLibraryCode() {
		return libraryCode;
	}

	public RMKUserInformation getHolder() {
		return holder;
	}

	public void setHolder(RMKUserInformation holder) {
		this.holder = holder;
	}

}
