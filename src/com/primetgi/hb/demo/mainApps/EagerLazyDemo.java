package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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

			//get the courses for instructor
			
			System.out.println("Courses: "+instructor.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
