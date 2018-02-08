package com.pazhamalai.rmklibraryapp;

import com.pazhamalai.librarymanagmentsystem.Book;

public class RMKLibrarySystem {
	public static void main(String args[]) {

		// creating student, faculty, librarian and rmkLibraryBook objects.
		RMKStudent ashok = new RMKStudent("ashok", 3827349, "cse", 2017);
		RMKFaculty manoj = new RMKFaculty("manoj", "ECE", (short) 2017, 382854);
		RMKLibrarian aravindh = new RMKLibrarian("aravindh", (short) 2012, 7894374);
		RMKLibrarian raja = new RMKLibrarian("raja", (short) 2000, 294828);

		Book halfGirlFriend = new Book("Half girlfriend", new String[] { "chetan bhaghat" }, 28357483, "Novel", 300,
				"Paperback");
		Book jimmyGold = new Book("Jimmy Gold", new String[] { "John rothstein", "Stephen king" }, 4829485, "Novel",
				600, "Hardcover");
		Book introductionToAlgorithms = new Book("Introduction to algorithms",
				new String[] { "Thomas H. Cormen", "L.Rivest" }, 2208502, "Educational", 1200, "PaperBack");
		Book theRiseOfIndia = new Book("The rise of India", new String[] { "Niranjan" }, 3208684, "Educational", 200,
				"Hardcover");
		Book wingsOfFire = new Book("The wings of fire", new String[] { "Dr Abdul kalaam" }, 194704, "Biography", 200,
				"Paperback");

		// adding rmk user to database.
		aravindh.addThisUserToDatabase(manoj);
		raja.addThisUserToDatabase(ashok);

		// adding book to library by student, faculty and librarian

		// Student can request to add book or librarian can directly add books
		RMKLibraryBook rmkHalfGirlFriend = ashok.requestToAddBook(halfGirlFriend, raja);
		RMKLibraryBook rmkJimmyGold = manoj.requestToAddBook(jimmyGold, aravindh);
		RMKLibraryBook rmkIntroductionToAlgorithms = aravindh.addBook(introductionToAlgorithms);
		RMKLibraryBook rmkTheRiseOfIndia = raja.addBook(theRiseOfIndia);
		RMKLibraryBook rmkTheWingsOfFire = ashok.requestToAddBook(wingsOfFire, raja);

		// taking books by student and faculty
		if (ashok.getPermissionToEnter(raja)) {
			ashok.takeBook(rmkTheRiseOfIndia, raja);
			ashok.takeBook(rmkTheWingsOfFire, aravindh);
		}

		if (manoj.getPermissionToEnter(aravindh)) {
			manoj.takeBook(rmkJimmyGold, aravindh);
			manoj.takeBook(rmkIntroductionToAlgorithms, raja);
		}

		// trying to take aldready taken book
		if (manoj.getPermissionToEnter(raja)) {
			manoj.takeBook(rmkTheWingsOfFire, raja);
		}

		// returning the book
		manoj.returnBook(rmkJimmyGold, raja);
		manoj.returnBook(rmkIntroductionToAlgorithms, aravindh);

		// trying to return non holding book
		manoj.returnBook(rmkTheWingsOfFire, raja);

		// trying to take more than limit
		ashok.takeBook(rmkIntroductionToAlgorithms, raja);
		ashok.takeBook(rmkJimmyGold, aravindh);
		ashok.takeBook(rmkHalfGirlFriend, aravindh);
	}
}