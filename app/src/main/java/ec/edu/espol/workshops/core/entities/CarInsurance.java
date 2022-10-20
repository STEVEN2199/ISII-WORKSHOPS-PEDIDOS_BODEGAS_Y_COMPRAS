package ec.edu.espol.workshops.core.entities;

import java.util.Locale;
import java.util.Scanner;
import ec.edu.espol.workshops.utils.InsuranceException;

/**
 * <h1>CarInsurance</h1>
 * 
 * The class insurance class, this handle the creation and data validation
 * for the customer that wants an insurance.
 * 
 * @author neoterux
 *
 */
public class CarInsurance {

	public static void processNewCustomer(final Customer customer) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("---Ingreso de información del cliente para cálculo de prima---");

		while (true) {

			try {

				System.out.println("Ingrese la edad del cliente: ");

				customer.setEdad(scanner.nextInt());
				scanner.nextLine();

				if (customer.getEdad() < 1 || customer.getEdad() > 150) {
					throw new InsuranceException("Edad invalida. Vuelva a intertarlo");
				}

				System.out.println("Está casado?(s/n) :");

				String stringInput = scanner.nextLine().toLowerCase(Locale.ENGLISH);

				if ("s".equals(stringInput)) {
					customer.setMaritalStatus(true);
				}
				else if ("n".equals(stringInput)) {
					customer.setMaritalStatus(false);
				} else {
					throw new InsuranceException(
							"Error en el ingreso del estado civil del cliente. Vuelva a intentarlo");
				}

				System.out.println("Sexo del cliente, M  para hombre o F para mujer: ");

				stringInput = scanner.nextLine().toUpperCase();

				if (!"H".equals(stringInput) && !"M".equals(stringInput)) {
					throw new InsuranceException("Error en el ingreso del sexo del cliente. Vuelva a intentarlo");
				}

				customer.setSex(stringInput.charAt(0));

				System.out.println("Cliente tiene licencia de conducir valida?(s/n) :");

				stringInput = scanner.nextLine().toLowerCase(Locale.ENGLISH);

				if ("n".equals(stringInput) || !"s".equals(stringInput)) {
					throw new InsuranceException("Cliente no tiene licencia de conducir valida");
				}
				
				

				customer.setLicenceIsValid(true);

				System.out.println(
						String.format("Prima para el cliente ingresado :$%d", customer.calculateInsuranceValue()));

				break;

			} catch (InsuranceException e) {

				System.out.println(e.getMessage());

			} catch (Exception e) {

				System.out.println("Error de dato: Vuelva a intentarlo");
			}
		}
		
		scanner.close();
		
	}

}
