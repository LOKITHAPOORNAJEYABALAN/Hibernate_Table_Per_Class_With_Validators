package com.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="customer")
public class Customer extends Person{
	public Customer(String email, String mobile, String customerType,String name,String address) {
		super(name,address);
		this.email = email;
		this.mobile = mobile;
		this.customerType = customerType;
	}
	
public Customer() {
	// TODO Auto-generated constructor stub
}

	@Email(message = "Invalid email format")
	  private String email;

	  @NotBlank
	  (message = "Mobile number cannot be blank")
	  @Pattern(regexp = "[0-9]{10}",flags = Flag.CASE_INSENSITIVE,message = "Invalid mobile number format")
	  private String mobile;

	  @NotBlank(message = "Customer type cannot be blank")
	  private String customerType;
	
	  public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getCustomerType() {
			return customerType;
		}

		public void setCustomerType(String customerType) {
			this.customerType = customerType;
		}
}
