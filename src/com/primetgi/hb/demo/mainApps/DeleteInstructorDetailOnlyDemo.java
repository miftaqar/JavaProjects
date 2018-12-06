package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorCopy;
import com.primetgi.hb.demo.entity.InstructorDetail;
import com.primetgi.hb.demo.entity.InstructorDetailCopy;

public class DeleteInstructorDetailOnlyDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetailCopy.class).addAnnotatedClass(InstructorCopy.class)
				.buildSessionFactory();

		// create the session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 17;
			InstructorDetailCopy instructorDetail = session.get(InstructorDetailCopy.class, theId);

			// print the instructor detail object
			System.out.println("Instructor Detail: " + instructorDetail);

			// print the associated object
			System.out.println("Associated Instructor: " + instructorDetail.getInstructorCopy());

			// remove the object reference
			// break the bi-directional relationship
			instructorDetail.getInstructorCopy().setInstructorDetailCopy(null);

			// delete the associated Instructor as CascadeType is ALL
			session.delete(instructorDetail);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
