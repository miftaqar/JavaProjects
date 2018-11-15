package com.primetgi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			// now get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve student based on id: primary key
			System.out.println("\nGetting Student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Deleting Student with Id: " + studentId);

			// delete the student
			session.delete(myStudent);

			// commit the transaction to apply in the database
			session.getTransaction().commit();
			
			//delete student with id = 2
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Deleting student with Id 2 using alternate approach");
			
			session.createQuery("delete Student where id = 2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}
}
