package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		// create the session
		Session session = sessionFactory.getCurrentSession();

		try {
		
			// start the transaction
			session.beginTransaction();

			//get instructor by its primary key
			int theId = 17;
			
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor: "+instructor);
			
			//delete the instrcutor
			if(instructor != null) {
				System.out.println("Deleting Instructor...");
				session.delete(instructor);
			}
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();
			
			sessionFactory.close();
			
			
		}

	}

}
