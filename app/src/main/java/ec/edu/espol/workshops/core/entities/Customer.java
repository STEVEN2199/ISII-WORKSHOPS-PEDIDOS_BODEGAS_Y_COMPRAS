package ec.edu.espol.workshops.core.entities;

import ec.edu.espol.workshops.core.insurance.InsuranceApplier;
import ec.edu.espol.workshops.utils.InsuranceException;

public class Customer implements InsuranceApplier{
	
	private int age ;
	private char sex;
	private boolean isMarried;
	private boolean driverLicenceIsValid;
	
	public Customer(){};
	
	public Customer(int age, char sex, boolean isMarried, boolean driverLicenceIsValid  ) {
		age = this.age;
		sex = this.sex;
		isMarried = this.isMarried;
		driverLicenceIsValid = this.driverLicenceIsValid;
	}

	    public int getEdad() {
	        return age;
	    }

	    public void setEdad(int age) {
	        this.age = age;
	    }

	    public char getSex(char sex) {
	        return sex;
	    }

	    public void setSex(char sex) {
	        this.sex = sex;
	    }

	    public boolean getMaritalStatus() {
	        return isMarried;
	    }

	    public void setMaritalStatus(boolean isMarried) {
	        this. isMarried = isMarried;
	    }

	    public boolean LicenceIsValid() {
	        return driverLicenceIsValid;
	    }

	    public void setLicenceIsValid(boolean driverLicenceIsValid) {
	        this.driverLicenceIsValid = driverLicenceIsValid;
	    }

	@Override
	public long calculateInsuranceValue() throws InsuranceException {
	    
		int premiumCost = -1;
		
	    if(sex == 'M' && !isMarried && age <25){
	    	premiumCost = BASE_VALUE + 1500;
	    }
	    else if(sex == 'F' || isMarried ){
	    	premiumCost= BASE_VALUE - 200;
	    }
	    else if(age >= 45 && age < 65){
	    	premiumCost= BASE_VALUE - 100;
	    }
	    return premiumCost;
	    
	  }
		
	}
