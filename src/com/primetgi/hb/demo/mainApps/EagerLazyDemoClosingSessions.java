package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;

public class EagerLazyDemoClosingSessions {

	public static void main(String[] args) {
		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create the session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 3;
			Instructor instructor = session.get(Instructor.class, theId);

			System.out.println("Luv2Code Instructor:  " + instructor);

			System.out.println("Luv2Code Courses: " + instructor.getCourses());
			
			session.getTransaction().commit();
			/*
			 * 1. close the session here to view an exception
			 */
			session.close();

			// get the courses for instructor

			/*
			 * 2. Using option-1 i.e. call getter method while session is opened
			 * 
			 */
			System.out.println("Luv2Code Courses: " + instructor.getCourses());

			// commit the transaction
			//session.getTransaction().commit();

			System.out.println("Luv2Code Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
