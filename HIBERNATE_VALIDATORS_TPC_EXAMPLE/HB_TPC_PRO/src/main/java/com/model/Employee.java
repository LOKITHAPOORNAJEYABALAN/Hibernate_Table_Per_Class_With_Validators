package com.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import javax.validation.constraints.*;
@Entity
@DiscriminatorValue(value="employee")
public class Employee extends Person{
	
	@NotNull(message = "Designation cannot be blank")
	  private String designation;

	  @Min(value = 0, message = "Salary cannot be negative")
	  private Float salary;

	  @Temporal(TemporalType.DATE)
	  private LocalDate dateOfJoining;
	  public Employee() {
		// TODO Auto-generated constructor stub
	}
	  
	public Employee(String designation, float salary, LocalDate dateOfJoining,String name,String address) {
		super(name,address);
		this.designation = designation;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	  
}
