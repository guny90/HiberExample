package com.guny.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.guny.hiber.example.dto.FourWheeler;
import com.guny.hiber.example.dto.TwoWheeler;
import com.guny.hiber.example.dto.UserDetails;
import com.guny.hiber.example.dto.Vehicle;

public class HibernateTest {
	
	private static SessionFactory factory;
	private static Session session;
	
	public static void main(String[] args) {

		//UserDetails user = new UserDetails("Gunel", new Date(), "Creator");
		//Address home = new Address("M. Genjevi", "Baku", "Azerbaijan", "1132");
		//Address office = new Address("H. Aliyev", "Baku", "Azerbaijan", "1029");

		//Vehicle vehicle = new Vehicle("Car");
		//user.getVehicles().add(vehicle);
		/*Vehicle bike = new Vehicle("Bike");
		user.getVehicles().add(bike);*/
		/*TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Scott");
		bike.setSteeringHandle("Shimano");
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Opel");
		car.setSteeringWheel("Opel wheel");*/
		//car.getUserList().add(user);
		//bike.getUserList().add(user);
		//car.setUser(user);
		//bike.setUser(user);
		//user.setVehicle(vehicle);
		/*user.setHomeAddress(home);
		user.setOfficeAddress(office);*/
		/*user.getListOfAddresses().add(home);
		user.getListOfAddresses().add(office);*/
		
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		session.beginTransaction();
		//session.persist(user);
		/*session.save(vehicle);
		session.save(car);
		session.save(bike);*/
		//UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		//session.delete(user);
		//user.setUserName("Updated User");
		//session.update(user);
		/*session.save(user);
		user.setUserName("Guny");
		user.setUserName("Guny90")*/;
		//Query query = session.createQuery("select userId, userName from UserDetails where userId = :userId and userName = :userName");
		//Query query = session.getNamedQuery("UserDetails.byName");
		//query.setInteger(0, 4);
		//query.setString(0, "User3");
		//query.setFirstResult(5);
		//query.setMaxResults(10);
//		List<Object[]> users = (List<Object[]>) query.list();
		
		//UserDetails exampleUser = new UserDetails();
		//exampleUser.setUserId(7); 
		//exampleUser.setUserName("User1%");
		//Example example = Example.create(exampleUser).enableLike();//excludeProperty("userName");
		
		//Criteria criteria = session.createCriteria(UserDetails.class);
		//criteria.add(example);
			/*.setProjection(Projections.count("userId"))
			.addOrder(Order.desc("userId"))
			.add(Restrictions.or(
					Restrictions.between("userId", 1, 3), 
					Restrictions.between("userId", 7, 50)));*/
				
		//List<UserDetails> users = (List<UserDetails>) criteria.list();
		System.out.println("select for user1");
		UserDetails user1 =  (UserDetails) session.get(UserDetails.class, 1);
		user1.setUserName("new user name");
		System.out.println("select for user2");
		UserDetails user2 =  (UserDetails) session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		System.out.println("select for user3");
		UserDetails user3 = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		//System.out.println("size: "+users.size());
		//for(UserDetails user : users)	{
			//System.out.println((Integer)user[0] + " " + (String)user[1]);
			//System.out.println(user.getUserName());
		//}
		/*user.setUserName("New name updated");
		
		session = factory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();*/
		/*
		user = null;
		session = factory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is " + user.getUserName());
		session.close();*/
		//System.out.println(user.getListOfAddresses().size());
	}

}
