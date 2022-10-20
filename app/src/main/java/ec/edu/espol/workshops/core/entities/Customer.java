package ec.edu.espol.workshops.core.entities;

import ec.edu.espol.workshops.core.insurance.InsuranceApplier;
import ec.edu.espol.workshops.utils.InsuranceException;

public class Customer implements InsuranceApplier{
	
	private int age ;
	private char sex;
	private boolean isMarried;
	private boolean driverLicenceValid;
	
	public Customer(){};
	
	public Customer(int age, char sex, boolean isMarried, boolean driverLicenceValid  ) {
		this.age = age;
		this.sex = sex;
		this.isMarried = isMarried;
		this.driverLicenceValid =driverLicenceValid ;
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
	        this. isMarried = isMarried;
	    }

	    public boolean getLicenceIsValid() {
	        return driverLicenceValid;
	    }

	    public void setLicenceIsValid(final boolean driverLicenceValid) {
	        this.driverLicenceValid = driverLicenceValid;
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
