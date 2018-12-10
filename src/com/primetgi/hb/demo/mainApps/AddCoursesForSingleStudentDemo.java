package com.primetgi.hb.demo.mainApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.primetgi.hb.demo.entity.Course;
import com.primetgi.hb.demo.entity.Instructor;
import com.primetgi.hb.demo.entity.InstructorDetail;
import com.primetgi.hb.demo.entity.Review;
import com.primetgi.hb.demo.entity.Student;

public class AddCoursesForSingleStudentDemo {

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

			// get the student from the database
			int theStudentId = 2;

			Student student = session.get(Student.class, theStudentId);

			System.out.println("Student Loaded: " + student);
			System.out.println("Student Courses: " + student.getCourses());

			// create more courses
			Course course1 = new Course("Web Designing");
			Course course2 = new Course("Python");
			Course course3 = new Course("Game Development");

			// add student to course
			course1.addStudent(student);
			course2.addStudent(student);
			course3.addStudent(student);

			// save the student
			System.out.println("Saving the course");
			session.save(course1);
			session.save(course2);
			session.save(course3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();

			sessionFactory.close();

		}

	}

}
