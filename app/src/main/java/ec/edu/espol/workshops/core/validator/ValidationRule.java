package ec.edu.espol.workshops.core.validator;

import ec.edu.espol.workshops.core.insurance.InsuranceApplier;

/**
 * This interface represents a validation rule that would be applied to a given
 * entity of type {@code T}.
 *
 * @author neoterux
 * @param <T> The type of the entity to validate.
 * @see ValidatorBundle
 */
@FunctionalInterface
public interface ValidationRule<T extends InsuranceApplier> {
  /**
   * Validate the given entity and checks if the rule is valid.
   *
   * @param entity The entity to validate
   * @return true if the validation is well.
   */
  boolean validate(T entity);
}
