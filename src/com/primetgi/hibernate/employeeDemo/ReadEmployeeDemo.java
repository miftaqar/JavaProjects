package com.primetgi.hibernate.employeeDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a new session
		Session session = factory.getCurrentSession();

		try {
			// begin transaction
			session.beginTransaction();
			
			// query for all employees
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			
			//display all employees
			displayEmployeeData(employees);
			
			//commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Db Operation Done");
		} finally {
			factory.close();
		}
		
	}

	private static void displayEmployeeData(List<Employee> employees) {
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
