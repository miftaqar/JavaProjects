package com.primetgi.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start the transaction
			session.beginTransaction();

			// query students
			List<Student> students = session.createQuery("from Student").getResultList();

			// display students
			displayStudents(students);

			// query students: lastName = 'Doe'
			students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

			// display students with lastName = 'Doe'
			System.out.println("Student With LastName = 'Doe'");
			displayStudents(students);

			// query students with firstName = 'Mohd' or lastName = 'mujahed'
			students = session
					.createQuery("from Student s where s.lastName = 'mujhaed' OR s.firstName = 'Mohd'").getResultList();
			
			//display Students with firstName = 'Mohd' or lastName = 'mujahed'
			System.out.println("\n\ndisplay Students with firstName = 'Mohd' or lastName = 'mujahed'");
			displayStudents(students);
			
			//query students with email address : '%yahoo.com'
			students = session
					.createQuery("from Student s where s.email Like '%yahoo.com'").getResultList();
			
			//display the result 
			System.out.println("students with email address : '%yahoo.com'");
			displayStudents(students);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
