package ec.edu.espol.workshops;

import ec.edu.espol.workshops.core.entities.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepsDefs {
    private long actualAnswer;
    /**
     * The customer that would be tested against the
     * calculations
     */
    public Customer targetCustomer = new Customer();
    @Given("An underage Citizen")
    public void citizen_is_underage() {
        targetCustomer.setEdad(17);

    }

    @Given("An old citizen (>=80 y.o)")
    public void citizen_is_more_than_80() {
        targetCustomer.setEdad(80);
    }
    @Given("his marital status is {string}")
    public void citizen_marital_status_is(String maritalStatus){
        targetCustomer.setMaritalStatus(switch (maritalStatus.toLowerCase()){
            case "m", "married" -> true;
            case "s", "single" -> false;
            default -> throw new IllegalStateException("Not a valid marital status");
        });

    }


    @Given("A citizen of age {int}")
    public void citizen_has_age(int age) {
        targetCustomer.setEdad(age);
    }
    @Given("is {string}")
    public void citizen_marital_status(String marital) {
        targetCustomer.setMaritalStatus("married".equalsIgnoreCase(marital));
    }
    @Given("The citizen is married")
    public void citizen_is_married() {
        targetCustomer.setMaritalStatus(true);
    }

    @Given("The citizen is single")
    public void citizen_isn_t_married() {
        targetCustomer.setMaritalStatus(false);
    }

    @Given("it's gender is {string}")
    public void cititzen_is_male(String gender) {
        targetCustomer.setSex(switch (gender.toLowerCase()) {
            case "male", "m" -> 'M';
                    case "female", "f" -> 'F';
                    default -> '\0';
        });
    }

    @Given("has valid license")
    public void citizen_has_valid_license() {
        this.targetCustomer.setLicenceIsValid(true);
    }
    @Given("has invalid license")
    public void citizen_has_invalid_license() {
        this.targetCustomer.setLicenceIsValid(false);
    }

    @When("wants to know the cost")
    public void citizen_want_the_prime_cost() {
        this.actualAnswer = targetCustomer.calculateInsuranceValue();
    }

    @Then("It should be {long}")
    public void the_value_is(long targetValue) {
        Assert.assertEquals(targetValue, this.actualAnswer);
    }

}

