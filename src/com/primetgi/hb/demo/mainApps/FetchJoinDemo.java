package com.primetgi.hb.demo.mainApps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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

			// option-2 Hibernate query with HQL

			// get the instructor from db
			int theId = 3;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId",
					Instructor.class);

			query.setParameter("theInstructorId", theId);

			Instructor instructor = query.getSingleResult();

			System.out.println("Luv2Code Instructor:  " + instructor);

			// commit the transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			System.out.println("Session closed\n ");

			// get courses for instructor
			System.out.println("Luv2Code Courses: " + instructor.getCourses());

			//
			// THIS HAPPENS SOMEWHERE ELSE / LATER IN THE PROGRAM

			// YOU NEED TO GET A NEW SESSION
			//

			System.out.println("\n\nluv2code: Opening a NEW session \n");

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			// get courses for a given instructor
			Query<Course> query1 = session
					.createQuery("select c from Course c " + "where c.instructor.id=:theInstructorId", Course.class);

			query1.setParameter("theInstructorId", theId);

			List<Course> tempCourses = query1.getResultList();

			System.out.println("tempCourses: " + tempCourses);

			// now assign to instructor object in memory
			instructor.setCourses(tempCourses);

			System.out.println("luv2code: Courses: " + instructor.getCourses());

			session.getTransaction().commit();

			System.out.println("Luv2Code Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}

/*
 * Eager solution would get everything no matter what, in lazy approach you can
 * omit fetching the Course when needed, and that results in faster fetch.
 * 
 * So main benefit of lazy is being flexible, where you can choose to get all
 * with DEMAND (due to a Join Fetch clause with Course) or get only Instructor
 * as default ( omit the Join Fetch ). Otherwise you would not be able to
 * control the behavior of retrieving the objects
 */
