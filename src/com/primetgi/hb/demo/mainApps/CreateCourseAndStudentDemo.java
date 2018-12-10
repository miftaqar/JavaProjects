package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;
import com.primetgi.hb.demo.entity.Review;
import com.primetgi.hb.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create the session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// create the course
			Course course = new Course("Java - beginner to Professional");

			// save the course and leverage the cascade all

			System.out.println("Saving the course");
			session.save(course);
			System.out.println("Saved the course: " + course);
			
			//create the students
			Student student1 = new Student("John", "Doe", "john.doe@gmail.com");
			Student student2 = new Student("Mary", "Jane", "Maty@jane.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			System.out.println("Saving Students");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved Students: "+course.getStudents());
			

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
