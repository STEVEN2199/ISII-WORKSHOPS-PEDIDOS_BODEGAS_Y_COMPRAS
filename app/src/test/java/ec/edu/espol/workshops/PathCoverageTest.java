package ec.edu.espol.workshops;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import ec.edu.espol.workshops.core.entities.CarInsurance;
import ec.edu.espol.workshops.core.entities.Customer;

class PathCoverageTest {

  private String checkRule(String cadena) {
    final var stdin = System.in;
    System.setIn(new ByteArrayInputStream(cadena.getBytes()));

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
    return result;
  }

  @Test
  void testPT1() {
    final var result = this.checkRule("45\ns\nm\ns");
    assertEquals(result, "Prima para el cliente ingresado :$200");
  }

  @Test
  void testPT10() {
    final var result = this.checkRule("30\nn\nM\nn\n30\nn\nM\ns");
    assertEquals(result, "Prima para el cliente ingresado :$500");
  }

  @Test
  void testPT2() {
    final var stdin = System.in;
    final var result = this.checkRule("50\ns\nf\ns");
    assertEquals(result, "Prima para el cliente ingresado :$200");
  }

  @Test
  void testPT3() {
    final var result = this.checkRule("30\nn\nm\ns");
    assertEquals(result, "Prima para el cliente ingresado :$500");
  }

  @Test
  void testPT4() {
    final var result = this.checkRule("24\nn\nm\ns");
    assertEquals(result, "Prima para el cliente ingresado :$2000");
  }

  @Test
  void testPT5() {
    final var result = this.checkRule("55\nn\nm\ns");
    assertEquals(result, "Prima para el cliente ingresado :$400");
  }

  @Test
  void testPT6() {
    final var result = this.checkRule("17\n30\nn\nf\ns");
    assertEquals(result, "Prima para el cliente ingresado :$300");
  }

  @Test
  void testPT7() {
    final var result = this.checkRule("81\n27\nn\nM\ns");
    assertEquals(result, "Prima para el cliente ingresado :$500");
  }

  @Test
  void testPT8() {
    final var result = this.checkRule("42\nhola\n42\nn\nM\ns");
    assertEquals(result, "Prima para el cliente ingresado :$500");
  }

  @Test
  void testPT9() {
    final var result = this.checkRule("30\nn\nt\n30\nn\nf\ns");
    assertEquals(result, "Prima para el cliente ingresado :$300");
  }

}
