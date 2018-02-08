package com.pazhamalai.rmklibraryapp;

import com.pazhamalai.librarymanagmentsystem.LibraryMemberAccess;

class RMKStandards {
	// limits given by RMK
	private static final int STUDENT_LIMIT = 4;
	private static final int FACULTY_LIMIT = 7;

	// checking whether user reached his limit.
	static boolean checkLimitOfUser(LibraryMemberAccess member, int booksTaken) {
		if (((RMKUserInformation) member).getUserType() == RMKUserInformation.user.STUDENT) {
			return (booksTaken < STUDENT_LIMIT) ? true : false;
		} else {
			return (booksTaken < FACULTY_LIMIT) ? true : false;
		}
	}
}
