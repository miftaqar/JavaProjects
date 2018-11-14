package com.primetgi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the student object
			System.out.println("Creating new Student Object");
			Student tempStudent = new Student("Mohd", "Mujahed", "m.m@gmail.com");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();

			//find out the students id: primary key
			System.out.println("Saved Student. Generated Id: "+tempStudent.getId());
			
			//now get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve student based on id: primary key
			System.out.println("\nGetting Student with id: "+tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: "+myStudent);
			
			System.out.println("Done");

		} finally {
			factory.close();
		}

	}
}
