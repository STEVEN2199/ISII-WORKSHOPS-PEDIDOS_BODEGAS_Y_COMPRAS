package ec.edu.espol.workshops.utils;

/**
 * This class represents a generic Exception that can be thrown by an insurance
 * process.
 *
 * @author neoterux
 *
 */
public class InsuranceException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public InsuranceException(String message) {
    super(message);
  }

  public InsuranceException(String message, Throwable cause) {
    super(message, cause);
  }

}
