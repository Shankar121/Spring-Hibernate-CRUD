package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Student;

public class DeleteHibernateDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student theStudent=session.get(Student.class, 5);
			session.delete(theStudent);
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			int x=session.createQuery("delete from Student where id>2").executeUpdate();
			System.out.println("x********"+x);
			session.getTransaction().commit();
			
			
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}
	
}
