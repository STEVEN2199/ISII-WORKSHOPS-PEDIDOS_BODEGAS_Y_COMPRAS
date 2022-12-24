package ec.edu.espol.workshops;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import ec.edu.espol.workshops.core.entities.CarInsurance;
import ec.edu.espol.workshops.core.entities.Customer;

class BranchCoverageTest {

  @Test
  void testBPA1() {
    final var stdin = System.in;
    System.setIn(new ByteArrayInputStream(
        "ten\n17\n81\n45\nhola\n45\ns\nt\n45\ns\nm\nn\n45\ns\nm\ns".getBytes()));

    final var byteArrayOutputStream = new ByteArrayOutputStream();
    final var ps = new PrintStream(byteArrayOutputStream);
    final var stdout = System.out;
    System.setOut(ps);

    final var customer = new Customer();

    CarInsurance.processNewCustomer(customer);

    System.setIn(stdin);
    System.setOut(stdout);

    final var outputText = byteArrayOutputStream.toString();
    final var key = "output:";
    final var output = outputText.substring(outputText.indexOf(key) + key.length()).trim()
        .split("\n");
    final var result = output[output.length - 1];
    assertEquals(result, "Prima para el cliente ingresado :$200");
  }

  @Test
  void testBPA2() {
    final var stdin = System.in;
    System.setIn(new ByteArrayInputStream("22\nn\nm\ns".getBytes()));

    final var byteArrayOutputStream = new ByteArrayOutputStream();
    final var ps = new PrintStream(byteArrayOutputStream);
    final var stdout = System.out;
    System.setOut(ps);

    final var customer = new Customer();

    CarInsurance.processNewCustomer(customer);

    System.setIn(stdin);
    System.setOut(stdout);

    final var outputText = byteArrayOutputStream.toString();
    final var key = "output:";
    final var output = outputText.substring(outputText.indexOf(key) + key.length()).trim()
        .split("\n");
    final var result = output[output.length - 1];
    assertEquals(result, "Prima para el cliente ingresado :$2000");
  }

}
