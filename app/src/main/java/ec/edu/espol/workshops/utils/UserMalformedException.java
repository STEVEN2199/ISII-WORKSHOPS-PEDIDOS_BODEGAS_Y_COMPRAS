package ec.edu.espol.workshops.utils;

/**
 * <h1>UserMalformedException.</h1>
 *
 * <p>
 * This exception represents an error when an specific user is configured from
 * an impossible or incorrect data given the rule of the field.
 * </p>
 *
 *
 * @author neoterux
 *
 */
public class UserMalformedException extends InsuranceException {

  private static final long serialVersionUID = 1L;

  /**
   * Creates a new {@code UserMalformedException} object with the message that
   * would be thrown without specify the cause.
   *
   *
   *
   * @param message The message of the exception
   */
  public UserMalformedException(String message) {
    super(message);
  }

  /**
   * Creates a new {@code UserMalformedException} object with the message and the
   * cause respectively.
   *
   *
   * @param message   The message of the exception.
   * @param throwable The cause of the error.
   */
  public UserMalformedException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
