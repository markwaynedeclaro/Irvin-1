package org.irvin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class LevelHasDependenciesException extends RuntimeException {
	
	private static final long serialVersionUID = -7320368160571625319L;

	public LevelHasDependenciesException(String exception)
	{
		super(exception);
	}
}
