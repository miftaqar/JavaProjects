package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			int theId = 21;
			Course course = session.get(Course.class, theId);
			
			//delete the course
			System.out.println("Deleting course: "+course.getTitle());

			session.delete(course);
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
