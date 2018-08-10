package com.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.entity.Student;

public class ReadHibernateDemo {

	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			System.out.println("starting save operation..");
			Student student=new Student("Puj", "Kumari", "puja@gmail.com");
			session.beginTransaction();
			System.out.println(student.toString());
			session.save(student);
			System.out.println("Saving complted...");
			session.getTransaction().commit();
			System.out.println("done");
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student theStudent=session.get(Student.class, student.getId());
			System.out.println(theStudent);
			session.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			factory.close();
			
		}
	}
	
}
