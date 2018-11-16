package com.primetgi.hibernate.employeeDemo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Employee;
import com.primetgi.hibernate.utilities.DateUtils;

public class UpdateEmployeeDemo {

	public static void main(String[] args) throws ParseException {

		// create session fatory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create a new session
		Session session = factory.getCurrentSession();

		try {
			int employeeId = 4;
			// begin the transaction
			session.beginTransaction();

			// Update Employee with its primary key
			Employee employee = session.get(Employee.class, employeeId);

			// updating the fields
			employee.setFirstName("Test First Name");
			employee.setLastName("Test Last Name");
			employee.setCompanyName("Test Company");

			// commit the transaction
			session.getTransaction().commit();

			// get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update query
			session.createQuery("update Employee set Last_Name = 'Test' where employeeId != " + employeeId)
					.executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			// get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Date
			String theDateOfJoiningStr = "31/12/1998";
			Date theDateOfJoining = DateUtils.parseDate(theDateOfJoiningStr);

			// update query
			session.createQuery(
					"update Employee set dateOfJoining = '" + theDateOfJoining + "' where lastName = 'Test' ").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();

			System.out.println("Db Operation done");

		} finally {
			factory.close();
		}

	}

}
