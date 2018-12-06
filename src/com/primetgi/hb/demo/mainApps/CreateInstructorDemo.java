package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create the session
		Session session = sessionFactory.getCurrentSession();

		try {

			// create the objects
			Instructor instructor = new Instructor("susan", "komen", "susan@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("www.susan.com", "Video Games");

			// associate the objects
			instructor.setInstructorDetail(instructorDetail);

			// start the transaction
			session.beginTransaction();

			// save the instructor
			// when saving the instructor object, associated object i.e. instructorDetail
			// will also be saved
			// because of CascadeType.ALL

			System.out.println("Saving Instructor: " + instructor);
			session.save(instructor);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
