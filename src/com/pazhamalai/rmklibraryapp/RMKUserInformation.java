package com.pazhamalai.rmklibraryapp;

//interface always public and abstract.
//Fields are always public static final.
//Methods are always public and abstract.
import com.pazhamalai.librarymanagmentsystem.*;

//LibraryMemberAccess can be extended by either RMKUserInformation or by RMKLibraryAccess because 
//LibraryMemberAccess provides both user information and library access
interface RMKUserInformation extends LibraryMemberAccess {
	int STUDENT_USER_TYPE = 1;
	int FACULTY_USER_TYPE = 2;

	int getUserType();
}