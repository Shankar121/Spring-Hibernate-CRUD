package com.test.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Student;

public class QueryHibernateDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			session=factory.getCurrentSession();
			session.beginTransaction();
			List<Student> theStudents=session.createQuery("from Student").list();
			displayStudent(theStudents);
			List<Student> theStudents2=session.createQuery("from Student where firstName='puja'").list();
			displayStudent(theStudents2);
			List<Student> theStudents3=session.createQuery("from Student where firstName like 'puj%'").list();
			displayStudent(theStudents3);
			session.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}

	private static void displayStudent(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}
	
}
