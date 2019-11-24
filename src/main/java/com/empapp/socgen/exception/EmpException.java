package com.empapp.socgen.exception;

import lombok.NoArgsConstructor;

/**
 * The EmpException wraps all unchecked standard Java exception and enriches
 * them with a custom error code. You can use this code to retrieve localized
 * error messages and to link to our online documentation.
 * 
 * @author Sumedh
 * @since 23 Nov 2019
 */
@NoArgsConstructor
public class EmpException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpException(String message) {
		super(message);
	}

}
