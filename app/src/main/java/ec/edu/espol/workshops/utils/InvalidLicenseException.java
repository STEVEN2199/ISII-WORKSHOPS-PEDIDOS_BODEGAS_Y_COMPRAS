package ec.edu.espol.workshops.utils;

/**
 * <h1>Invalid License Exception</b>
 * 
 * <p>
 * This class represents an error while validating or checking the 
 * validity of a given driving license.
 * </p>
 * 
 * @author neoterux
 *
 */
public class InvalidLicenseException extends RuntimeException {

	private static final long serialVersionUID = -2134494298989871757L;
	
	
	/**
	 * Creates a new {@code InvalidLicenseException} object that has
	 * a specific message with the error cause, but not the cause.
	 *  
	 * @param message The message to throw
	 */
	public InvalidLicenseException(String message) {
		super(message);
	}
	
	/**
	 * Creates a new {@code InvalidLicenseException} object that has
	 * an detailed message and a specific cause.
	 * 
	 * @param message The message to throw.
	 * @param cause The cause of the error.
	 */
	public InvalidLicenseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
