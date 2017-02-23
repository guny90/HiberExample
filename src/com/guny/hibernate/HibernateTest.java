package com.guny.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.guny.hiber.example.dto.Address;
import com.guny.hiber.example.dto.UserDetails;

public class HibernateTest {
	
	private static SessionFactory factory;
	private static Session session;
	
	public static void main(String[] args) {

		UserDetails user = new UserDetails("User1", new Date(), "Description1");
		Address home = new Address("home_street1", "home_city1", "home_state1", "home_pin1");
		//user.setHomeAddress(home);
		Address office = new Address("office_street1", "office_city1", "office_state1", "office_pin1");
		//user.setOfficeAddress(office);
		user.getListOfAddresses().add(home);
		user.getListOfAddresses().add(office);
		
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = factory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is " + user.getUserName());
		user.getListOfAddresses();
		session.close();
	}

}
