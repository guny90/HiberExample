package com.guny.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.guny.hiber.example.dto.UserDetails;

public class HibernateTest {
	
	private static SessionFactory factory;
	private static ServiceRegistry registry;

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("1 User");
		user.setAddress("1 address");
		user.setJoinedDate(new Date());
		user.setDescription("1 Description");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("2 user");
				
		Configuration conf = new Configuration().configure();
		registry = new StandardServiceRegistryBuilder().
				applySettings(conf.getProperties()).build();
		factory = conf.addPackage("com.guny.hiber.example.dto").
				addAnnotatedClass(UserDetails.class).
				buildSessionFactory(registry);
		//factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = factory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is " + user.getUserName());
	}

}
