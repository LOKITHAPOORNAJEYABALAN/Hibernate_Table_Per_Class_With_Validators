package com.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Person")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="category",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="general")


public class Person {
	public Person( String name,String address) {
		super();
		this.Name = name;
		this.Address=address;
	}
	
	

	public Person() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long Id;
	
	  @NotBlank(message = "Name cannot be blank")
	  private String Name;

	  @NotBlank(message = "Address cannot be blank")
	  private String Address;

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}

}