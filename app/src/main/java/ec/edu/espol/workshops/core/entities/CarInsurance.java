package ec.edu.espol.workshops.core.entities;

import ec.edu.espol.workshops.utils.InsuranceException;

import java.util.Locale;
import java.util.Objects;
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

//    final var scanner = new Scanner(System.in);
    final var scanner = new ScannerWrapper(new Scanner(System.in));
  
    // scanner.getBytes(Charset.forName("UTF-8"));
  
    System.out.println("---Ingreso de información del cliente para cálculo de prima---");
  
    while (true) {
    
      try {
      
        System.out.println("Ingrese la edad del cliente: ");
      
        customer.setEdad(scanner.scanInt());
      
        if (customer.getEdad() < 18) {
          throw new InsuranceException("No puede contratar seguro: Menor de edad");
        }
        if (customer.getEdad() >= 80) {
          throw new InsuranceException("No puede contratar seguro:Edad Avanzada");
        }
      
        System.out.println("Está casado?(s/n) :");
      
        var stringInput = scanner.scanString().toLowerCase(Locale.ENGLISH);
      
        if ("s".equalsIgnoreCase(stringInput)) {
          customer.setMaritalStatus(true);
        } else if ("n".equalsIgnoreCase(stringInput)) {
          customer.setMaritalStatus(false);
        } else {
          throw new InsuranceException(
                  "Error en el ingreso del estado civil del cliente. Vuelva a intentarlo");
        }
        System.out.println("Sexo del cliente, M  para hombre o F para mujer: ");
      
        stringInput = scanner.scanString().toUpperCase(Locale.getDefault());
      
        if (!"M".equals(stringInput) && !"F".equals(stringInput)) {
          throw new InsuranceException(
                  "Error en el ingreso del estado civil del cliente. Vuelva a intentarlo");
        }
        customer.setSex(stringInput.charAt(0));
      
        System.out.println("Cliente tiene licencia de conducir valida?(s/n) :");
      
        stringInput = scanner.scanString().toLowerCase(Locale.ENGLISH);
      
        if (!"s".equalsIgnoreCase(stringInput)) {
          throw new InsuranceException("Cliente no tiene licencia de conducir valida");
        }
      
        customer.setLicenceIsValid(true);
      
        System.out.printf("Prima para el cliente ingresado :$%d%n",
                          customer.calculateInsuranceValue()
                         );
      
        break;
      
      } catch (final InsuranceException e) {
      
        System.out.println(e.getMessage());
      
      } catch (final Exception e) {
      
        System.out.println("Error de dato: Vuelva a intentarlo");
      }
    }
  
    scanner.close();
  
  }
  
  private static class ScannerWrapper {
    private final Scanner scanner;
    
    ScannerWrapper (Scanner scanner) {
      this.scanner = Objects.requireNonNull(scanner);
    }
    
    /**
     * Scan an integer value using the given scanner and safely clear buffer
     *
     * @return the int read by the scanner
     */
    public int scanInt () {
      try {
        return scanner.nextInt();
      }
      finally {
        scanner.nextLine();//discarded
      }
    }
    
    /**
     * Scan the inserted line by the user.
     *
     * @return A string with the raw representation of the user input
     */
    public String scanString () {
      return scanner.nextLine();
    }
    
    public void close () {
      scanner.close();
    }
    
    
  }
  
}
