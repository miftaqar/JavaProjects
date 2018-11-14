package com.primetgi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the student object
			System.out.println("Creating 3 Student Object");
			Student tempStudent1 = new Student("Rock", "Dwayne", "r.d@gmail.com");
			Student tempStudent2 = new Student("John", "Doe", "j.d@gmail.com");
			Student tempStudent3 = new Student("James", "Watson", "J.w@gmail.com");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

}
