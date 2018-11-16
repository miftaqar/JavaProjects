package com.primetgi.hibernate.employeeDemo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Employee;
import com.primetgi.hibernate.utilities.DateUtils;

public class CreateEmployeeDemo {

	public static void main(String[] args) throws ParseException {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create the session and get the current session
		Session session = factory.getCurrentSession();

		try {
			// create the Employee Object
			System.out.println("Creating the employee object");
			Employee employee1 = new Employee("Ron", "Watson", "Abx Limited", DateUtils.parseDate("12/05/2001"));
			Employee employee2 = new Employee("John", "Doe", "SAA Limited", DateUtils.parseDate("12/05/2001"));
			Employee employee3 = new Employee("Jennifer", "Regal", "MOP Limited", DateUtils.parseDate("12/05/2001"));
			Employee employee4 = new Employee("Ricky", "Adam", "PAL Limited", DateUtils.parseDate("12/05/2001"));
			Employee employee5 = new Employee("Andrew", "Jordan", "AJ Companies", DateUtils.parseDate("12/05/2001"));

			// begin the transaction
			session.beginTransaction();

			// save the employee object
			System.out.println("Saving the employee Object");
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);
			session.save(employee5);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Db Operation Done");

		} finally {
			factory.close();
		}

	}

}
