package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;
import com.primetgi.hb.demo.entity.Review;

public class DeleteCoursesReviewDemo2 {

	public static void main(String[] args) {
		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create the session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// get the course
			int theId = 10;

			Course course = session.get(Course.class, theId);

			// delete the course

			System.out.println("Deleting the course: " + course);

			System.out.println("Deleting the course Reviews: " + course.getReviews());

			session.delete(course);

			System.out.println("Deleted");

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
