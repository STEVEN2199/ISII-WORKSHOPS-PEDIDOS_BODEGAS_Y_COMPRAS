package ec.edu.espol.workshops.core.entities;

import ec.edu.espol.workshops.core.insurance.InsuranceApplier;
import ec.edu.espol.workshops.utils.InsuranceException;

/**
 * <h1>Customer Class.</h1>
 *
 * <p>
 * This class represents a customer entity that is on the project.
 * </p>
 *
 *
 *
 * @author neoterux
 *
 **/
public class Customer implements InsuranceApplier {

  private int age;
  private char sex;
  private boolean isMarried;
  private boolean driverLicenceValid;

  public Customer() {
  }

  @Override
  public long calculateInsuranceValue() throws InsuranceException {

    var premiumCost = BASE_VALUE;
    if (this.sex == 'F' || this.isMarried) {
      premiumCost -= 200;
    }
    if (this.sex == 'M' && !this.isMarried && this.age < 25) {
      premiumCost += 1500;
    }
    if (this.age >= 45 && this.age < 65) {
      premiumCost -= 100;
    }
    return premiumCost;

  }

  public int getEdad() {
    return this.age;
  }

  public void setEdad(final int age) {
    this.age = age;
  }

  public void setLicenceIsValid(final boolean driverLicenceValid) {
    this.driverLicenceValid = driverLicenceValid;
  }

  public void setMaritalStatus(final boolean isMarried) {
    this.isMarried = isMarried;
  }

  public void setSex(final char sex) {
    this.sex = sex;
  }

}
