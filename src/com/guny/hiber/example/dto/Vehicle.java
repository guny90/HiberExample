package com.guny.hiber.example.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEH_TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Undefined")*/
@Table(name="VEHICLE")
public class Vehicle {
	@Id @GeneratedValue
	@Column(name="VEH_ID")
	private int vehicleId;
	@Column(name="VEH_NAME")
	private String vehicleName;
	/*
	@ManyToMany
	@JoinTable(name="VEHICLE_USER", joinColumns=@JoinColumn(name="VEH_ID"), inverseJoinColumns=@JoinColumn(name="USER_ID"))
	Collection<UserDetails> user = new ArrayList<UserDetails>();
	
	public Collection<UserDetails> getUserList() {
		return user;
	}
	public void setUserList(Collection<UserDetails> userList) {
		this.user = userList;
	}
	*/
	public Vehicle() {
		super();
	}
	public Vehicle(String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	/*
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="USER_ID")
	private UserDetails user;

	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	*/

}
