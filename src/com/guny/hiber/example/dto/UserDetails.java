package com.guny.hiber.example.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@SuppressWarnings("deprecation")
@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
@NamedQuery(name="UserDetails.byId", query="select userId, userName from UserDetails where userId = ?")
@NamedNativeQuery(name="UserDetails.byName", query="select * from user_details where user_name=?", resultClass=UserDetails.class)
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	/*@OneToOne
	@JoinColumn(name="VEH_ID")
	private Vehicle vehicle;
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
	//@ManyToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	@OneToMany(cascade=CascadeType.PERSIST)
	//@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="VEH_ID"))
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
		
	public Collection<Vehicle> getVehicles() {
		return vehicle;
	}

	public void setVehicles(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	@Column(name="JOINED_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Lob
	@Column(name="DESCR")
	private String description;
	
	/*@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator = "sequence-gen", type = @Type(type = "long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();*/
	
	/*
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE")),
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PIN"))
	})
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="OFFICE_STREET")),
		@AttributeOverride(name="city", column=@Column(name="OFFICE_CITY")),
		@AttributeOverride(name="state", column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="pincode", column=@Column(name="OFFICE_PIN"))
	})
	private Address officeAddress;
*/
	public UserDetails() {
		super();
	}
	
	public UserDetails(String userName, Date joinedDate, String description) {
		super();
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

	
	
	/*
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	*/
	
}
