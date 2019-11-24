package com.empapp.socgen.configuration;

import java.util.List;
import java.util.Objects;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * Custom Exception handler to override certain required fields like error
 * message path and so on.
 * 
 * @author sumedh
 *
 */
@RestControllerAdvice
public class RestExceptionConfigurationHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest requset) {

		GlobalExceptionPojo globalExcPojo = new GlobalExceptionPojo();

		// Handle All Field Validation Errors
		if (ex instanceof MethodArgumentNotValidException) {
			List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
			fieldErrors.stream().filter(error -> Objects.nonNull(error.getDefaultMessage())).findFirst()
					.ifPresent(msg -> globalExcPojo.setMessage(msg.getDefaultMessage()));

		} else if (ex instanceof OptimisticLockingFailureException) {
			globalExcPojo.setMessage(
					"The record you are working on has been modified by another user. Changes you have made have not been saved, please resubmit.");
		} else {
			globalExcPojo.setMessage(ex.getLocalizedMessage());
		}

		globalExcPojo.setError(ex.getClass().getCanonicalName());
		globalExcPojo.setPath(((ServletWebRequest) requset).getRequest().getServletPath());

		// return exceptionMessageObj;
		return new ResponseEntity<>(globalExcPojo, null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

/**
 * This Exception pojo contains message, path and error fields, used in
 * {@code RestExceptionHandler} class by creating an object of it and assigning
 * values to it, and then passed over Response Entity object}
 * 
 * @author sumedh
 *
 */
class GlobalExceptionPojo {
	private String message;
	private String error;
	private String path;

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
