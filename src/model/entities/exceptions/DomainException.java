package model.entities.exceptions;

/**
 * Custom exception class used to represent domain-specific business rule violations.
 * 
 * This exception extends RuntimeException, allowing it to be thrown without requiring
 * explicit handling or declaration in method signatures. It's commonly used to 
 * encapsulate validation errors or rule breaches in the domain layer.
 */
public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	// Constructs a new DomainException with a specified error message.
	public DomainException(String msg) {
		super(msg);
	}
}
