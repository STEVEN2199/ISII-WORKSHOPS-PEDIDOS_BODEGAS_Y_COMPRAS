package ec.edu.espol.workshops;

import ec.edu.espol.workshops.core.entities.CarInsurance;
import ec.edu.espol.workshops.core.entities.Customer;

/**
 * The Start point of the insurance calculator.
 *
 * @author neoterux
 *
 */
public class App {

  /**
   * Main function of main.
   *
   * @param args the args
   **/
  public static void main(String[] args) {

    final var customer = new Customer();

    CarInsurance.processNewCustomer(customer);

  }
}
