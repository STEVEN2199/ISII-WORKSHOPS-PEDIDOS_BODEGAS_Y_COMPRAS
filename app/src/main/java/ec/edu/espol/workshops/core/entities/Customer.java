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

  /**
   * Create a new Customer object.
   *
   * @param age The age of the customer
   * @param sex The sex of the customer
   * @param isMarried Is if married or not
   * @param driverLicenceValid  The valid thru date
   */
  public Customer(int age, char sex, boolean isMarried, boolean driverLicenceValid) {
    this.age = age;
    this.sex = sex;
    this.isMarried = isMarried;
    this.driverLicenceValid = driverLicenceValid;
  }

  public int getEdad() {
    return age;
  }

  public void setEdad(final int age) {
    this.age = age;
  }

  public char getSex(final char sex) {
    return sex;
  }

  public void setSex(final char sex) {
    this.sex = sex;
  }

  public boolean getMaritalStatus() {
    return isMarried;
  }

  public void setMaritalStatus(final boolean isMarried) {
    this.isMarried = isMarried;
  }

  public boolean isLicenseValid () {
    return driverLicenceValid;
  }

  public void setLicenceIsValid(final boolean driverLicenceValid) {
    this.driverLicenceValid = driverLicenceValid;
  }

  @Override
  public long calculateInsuranceValue() throws InsuranceException {
    if (age >= 80 || !isLicenseValid() || age < 0) return -1;
  
    int premiumCost = BASE_VALUE;
    if (sex == 'F' || isMarried) {
      premiumCost -= 200;
    }
    if (sex == 'M' && !isMarried && age < 25) {
      premiumCost += 1500;
    }
    if (age >= 45 && age < 65) {
      premiumCost -= 100;
    }
    return premiumCost;
  
  }

}
