package com.springboot.eVallet.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class FoundShouldNotGoBelowZero extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FoundShouldNotGoBelowZero(String message) {
		super(message);
	}
}
