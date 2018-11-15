package com.primetgi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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

			System.out.println("Updating Student");
			myStudent.setFirstName("Urfiyath");

			// commit the transaction to apply in the database
			session.getTransaction().commit();

			// start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("Update Email for all Students");

			session.createQuery("update Student set email = 'testmail@gmail.com'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			// start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("Update Email for onyl specific Students");

			session.createQuery("update Student set email = 'mohd.ahmed@gmail.com' where id=" + studentId)
					.executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}
}
