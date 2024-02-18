package com.StudentMarks.exception;

import java.util.Date;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
	
	 public ResourceNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public ResourceNotFoundException(String entity, String field, String value) {
	        super(String.format("%s not found with %s: %s", entity, field, value));
	    }

	    public ResourceNotFoundException(String entity, String field, String value, Integer id) {
	        super(String.format("%s not found with %s: %s", entity, field, value));
	    }
	}
