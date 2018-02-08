package com.pazhamalai.librarymanagmentsystem;

public class Book {
	private String title;
	private String authours[];
	private long isbnNumber;
	private String genre;
	private int totalPages;
	private String typeOfCover;

	public Book(String title, String[] authours, long isbnNumber, String genre, int totalPages, String typeOfCover) {
		this.title = title;
		this.authours = authours;
		this.isbnNumber = isbnNumber;
		this.genre = genre;
		this.totalPages = totalPages;
		this.typeOfCover = typeOfCover;
	}

	public String getTitle() {
		return title;
	}

	public String[] getAuthours() {
		return authours;
	}

	public long getIsbnNumber() {
		return isbnNumber;
	}

	public String getGenre() {
		return genre;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public String getTypeOfCover() {
		return typeOfCover;
	}

	public void openBook() {
		System.out.println("Book opened");
	}

}
