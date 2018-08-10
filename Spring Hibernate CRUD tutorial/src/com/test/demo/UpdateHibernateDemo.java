package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Student;

public class UpdateHibernateDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student theStudent=session.get(Student.class, 1);
			theStudent.setFirst_name("Shanky");
			System.out.println(theStudent);
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			int x=session.createQuery("update Student set email='shanky@gmail.com' where id=1").executeUpdate();
			System.out.println("x********"+x);
			session.getTransaction().commit();
			
			
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}
	
}
