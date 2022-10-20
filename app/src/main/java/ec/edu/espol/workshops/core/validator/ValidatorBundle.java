package ec.edu.espol.workshops.core.validator;

import ec.edu.espol.workshops.core.insurance.InsuranceApplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



/**
 * <h1>Validator Bundle.</h1>
 *
 *<p>
 * This class represents a group of validation rules that would be used to
 * validated a given {@link InsuranceApplier} and check if can proceed.
 * </p>
 *
 * @author neoterux
 *
 * @param <T> The type of the Insurance applier
 */
public final class ValidatorBundle<T extends InsuranceApplier> {

  private List<ValidationRule<T>> validationRules;

  /**
   * Creates the base of the validator bundle.
   */
  private ValidatorBundle() {
    this.validationRules = new ArrayList<>();
  }

  /**
   * Create a new Validator bundle with the gien rules.
   *
   * @param rule The rule
  
   * @return The Current vlaidator bundle
   */
  public ValidatorBundle<T> addRule(ValidationRule<T> rule) {
    Optional.of(rule); // Checks that the object is not null
    validationRules.add(rule);
    return this;
  }

  public ValidatorBundle<T> removeRule(ValidationRule<T> rule) {
    validationRules.remove(rule);
    return this;
  }

  
  public List<ValidationRule<T>> getRulesList() {
    return Collections.unmodifiableList(this.validationRules);
  }

  /**
   * Check the given target and validate if all the rules registered are valid
   * with the target.
   *
   * @param target The target to validate.
   * @return true if the Validation go well
   * @throws EmptyValidatorException If there's no rules registered on this bundle
   * @throws NullPointerException    If the given target is null
   */
  public boolean check(T target) throws EmptyValidatorException {
    if (this.validationRules.isEmpty()) {
      throw new EmptyValidatorException("No rules are registered on bundle");
    }

    return this.validationRules.stream().allMatch(rule -> rule.validate(Optional.of(target).get()));
  }

}
