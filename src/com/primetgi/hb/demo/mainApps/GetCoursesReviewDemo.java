package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;
import com.primetgi.hb.demo.entity.Review;

public class GetCoursesReviewDemo {

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

			//get the course
			int theId = 10;
			
			//print the course
			Course course = session.get(Course.class, theId);
			
			//print the course reviews
			System.out.println("Reviews: "+course.getReviews());
			
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
