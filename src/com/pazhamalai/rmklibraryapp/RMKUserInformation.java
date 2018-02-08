package com.pazhamalai.rmklibraryapp;

//interface always public and abstract.
//Fields are always public static final.
//Methods are always public and abstract.
import com.pazhamalai.librarymanagmentsystem.*;

//LibraryMemberAccess can be extended by either RMKUserInformation or by RMKLibraryAccess because 
//LibraryMemberAccess provides both user information and library access
interface RMKUserInformation extends LibraryMemberAccess {
	enum user {
		STUDENT, FACULTY;
	}

	user getUserType();
}