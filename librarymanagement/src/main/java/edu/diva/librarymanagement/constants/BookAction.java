package edu.diva.librarymanagement.constants;

import java.util.HashMap;
import java.util.Map;

public enum BookAction {
	BORROW(LibraryManagementConstants.ACTION_BORROW), RETURN(LibraryManagementConstants.ACTION_RETURN);
	
	private int code;

	BookAction(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	private static final Map<String, BookAction> lookup = new HashMap<>();
	static {
		for (BookAction action : BookAction.values()) {
			lookup.put(action.toString(), action);
		}
	}

	public static BookAction getActionByCode(String action) {
		return lookup.get(action);
	}
}
