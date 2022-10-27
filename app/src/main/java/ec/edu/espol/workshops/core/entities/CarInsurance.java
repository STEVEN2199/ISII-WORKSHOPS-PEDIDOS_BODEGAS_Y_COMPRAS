package ec.edu.espol.workshops.core.entities;

import ec.edu.espol.workshops.utils.InsuranceException;

import java.util.Locale;
import java.util.Scanner;

/**
 * <h1>CarInsurance.</h1>
 *
 * <p>
 * The class insurance class, this handle the creation and data validation for the customer that
 * wants an insurance.
 * </p>
 *
 * @author neoterux
 *
 */
public class CarInsurance {

  /**
   * function that process a {@code Customer}.
   *
   * @param customer The customer to process
   */
  public static void processNewCustomer(final Customer customer) {

    final var scanner = new Scanner(System.in);

    // scanner.getBytes(Charset.forName("UTF-8"));

    System.out.println("---Ingreso de información del cliente para cálculo de prima---");

    while (true) {

      try {

        System.out.println("Ingrese la edad del cliente: ");

        customer.setEdad(scanner.nextInt());
        scanner.nextLine();

        if (customer.getEdad() < 18) {
          throw new InsuranceException("No puede contratar seguro: Menor de edad");
        }
        if (customer.getEdad() >= 80) {
          throw new InsuranceException("No puede contratar seguro:Edad Avanzada");
        }

        System.out.println("Está casado?(s/n) :");

        var stringInput = scanner.nextLine().toLowerCase(Locale.ENGLISH);

        if ("s".equals(stringInput)) {
          customer.setMaritalStatus(true);
        } else if ("n".equals(stringInput)) {
          customer.setMaritalStatus(false);
        } else {
          throw new InsuranceException(
              "Error en el ingreso del estado civil del cliente. Vuelva a intentarlo");
        }
        System.out.println("Sexo del cliente, M  para hombre o F para mujer: ");

        stringInput = scanner.nextLine().toUpperCase(Locale.getDefault());

        if (!"M".equals(stringInput) && !"F".equals(stringInput)) {
          throw new InsuranceException(
              "Error en el ingreso del estado civil del cliente. Vuelva a intentarlo");
        }
        customer.setSex(stringInput.charAt(0));

        System.out.println("Cliente tiene licencia de conducir valida?(s/n) :");

        stringInput = scanner.nextLine().toLowerCase(Locale.ENGLISH);

        if ("n".equals(stringInput) || !"s".equals(stringInput)) {
          throw new InsuranceException("Cliente no tiene licencia de conducir valida");
        }

        customer.setLicenceIsValid(true);

        System.out.println(String.format("Prima para el cliente ingresado :$%d",
            customer.calculateInsuranceValue()));

        break;

      } catch (final InsuranceException e) {

        System.out.println(e.getMessage());

      } catch (final Exception e) {

        System.out.println("Error de dato: Vuelva a intentarlo");
      }
    }

    scanner.close();

  }

}
