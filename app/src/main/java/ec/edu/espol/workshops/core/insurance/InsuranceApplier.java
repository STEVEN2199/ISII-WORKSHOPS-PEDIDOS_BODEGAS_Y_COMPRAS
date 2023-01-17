package ec.edu.espol.workshops.core.insurance;

import ec.edu.espol.workshops.utils.InsuranceException;

/**
 * This interface represents an a capable entity to apply at an insurance.
 *
 * @author neoterux
 *
 */
public interface InsuranceApplier {

  /**
   * The base value of an insurance value.
   */
  final int BASE_VALUE = 600;

  /**
   * Calculates the value of the insurance.
   *
   * @return The value of the insurance to pay.
   * @throws InsuranceException If the applier cannot apply to an insurance
   */
  long calculateInsuranceValue() throws InsuranceException;

}
