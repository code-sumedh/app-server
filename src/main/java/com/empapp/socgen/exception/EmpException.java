package com.empapp.socgen.exception;

/**
 * The EmpException wraps all unchecked standard Java exception and enriches
 * them with a custom error code. You can use this code to retrieve localized
 * error messages and to link to our online documentation.
 * 
 * @author Sumedh
 * @since 23 Nov 2019
 */
public class EmpException extends RuntimeException {

	private String message;
	private String error;
	private String path;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpException(String message) {
		super(message);
		this.message = message;
	}

	public EmpException() {
		super();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
