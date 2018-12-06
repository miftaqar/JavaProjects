package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;
import com.primetgi.hb.demo.entity.Review;

public class CreateCoursesReviewDemo {

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

			// create the course
			Course course = new Course("Pacman");

			// add some reviews
			course.addReview(new Review("Great Course....Loved It"));
			course.addReview(new Review("Awesome Course....Liked It"));
			course.addReview(new Review("Not Upto the mark"));

			// save the course and leverage the cascade all
			session.save(course);
			
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
