package ec.edu.espol.workshops.core.validator;

/**
 * <h1>Empty Validation Exception</h1>
 * 
 * This class represents an error when a validator has no validation rules
 * to apply to something.
 * 
 * @author neoterux
 *
 */
public class EmptyValidatorException extends RuntimeException {
	
	/**
	 * Creates a new {@code EmptyValidationException} object that 
	 * would throw the given message.
	 * 
	 * @param message The message to Throw.
	 */
	public EmptyValidatorException(String message) {
		super(message);
	}
	
	/**
	 * Creates a new {@code EmptyValidatorException} with the given parameters.
	 * 
	 * @param message The message that would be thrown
	 * @param cause The cause of the error.
	 */
	public EmptyValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

}
