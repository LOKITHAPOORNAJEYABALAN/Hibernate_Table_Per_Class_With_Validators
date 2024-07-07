package com.model;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TPC {
	public static void main(String[] args) {
		ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
		Validator validator=validatorFactory.getValidator();
		//SessionFactory factory= new Configuration().configure().buildSessionFactory();

		
		Person validPerson= new Person ("Lokitha","Periyar nagar,kariyapatti");
		Customer validPerson2= new Customer("lokitha@gmail.com","9876543210","Regular", "Poorna","Nehru Street,Madurai");
		
		Employee validPerson3= new Employee("CEO", 10000, LocalDate.of(2020, 10, 07),"Radhika","Dubai kuruku sandhu ,dubai");
		Set<ConstraintViolation<Person>> violations = validator.validate(validPerson);

		violations =validator.validate(validPerson);
		if(violations.isEmpty()) {
			savePerson(validPerson);
			savePerson(validPerson2);
			savePerson(validPerson3);
			System.out.println("Valid person data provided.");
			
			}
		else {
			System.out.println("Invalid person data found.");
			for(ConstraintViolation<Person> violation:violations) {
				System.out.println(violation.getMessage());
			}
	}
		
}
	public static void savePerson(Person person) {
		
		SessionFactory factory=HBUtil.getSessionFactory();
		Session session=factory.openSession();
		
		Transaction transaction =null;
		try {
			transaction = session.beginTransaction();
	        session.save(person);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		}
}