package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			int theId = 2;
			Instructor instructor = session.get(Instructor.class, theId);

			// create some courses
			Course tempCourse1 = new Course("Auto CAD");
			Course tempCourse2 = new Course("Drawing");

			// add courses to instructor
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);

			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
