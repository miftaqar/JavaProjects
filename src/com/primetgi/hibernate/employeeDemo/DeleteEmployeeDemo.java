package com.primetgi.hibernate.employeeDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {

		// create session fatory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create a new session
		Session session = factory.getCurrentSession();

		try {
			int employeeId = 3;
			// begin the transaction
			session.beginTransaction();

//			// Update Employee with its primary key
//			Employee employee = session.get(Employee.class, employeeId);
//			
//			//deleting row for specific employeeId
//			session.delete(employee);
//			
//			//commit the transaction
//			session.getTransaction().commit();
//			
//			//get a new session
//			session = factory.getCurrentSession();
//			session.beginTransaction();
			
			//delete query
			session.createQuery("Delete Employee where employeeId = "+employeeId).executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Db Operation done");

		} finally {
			factory.close();
		}

	}

}
