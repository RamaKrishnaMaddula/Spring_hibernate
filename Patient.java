package com.krishnas.hms.entity;
import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="patient")
public class Patient {
	
	//Annotate the class with entity and table

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="joining_date")
	private Timestamp joining;
	
	@Column(name="suffer_from")
	private int sufferFrom;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="doc_id")
	private Doctor doctor;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="ctaker_id")
	private CareTaker careTaker;
	
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="sickness_patient",
			  joinColumns=@JoinColumn(name="pat_id"),
			  inverseJoinColumns=@JoinColumn(name="sick_id"))
	private List<Sickness> sickness;
	
	
	public List<Sickness> getSickness() {
		return sickness;
	}


	public void setSickness(List<Sickness> sickness) {
		this.sickness = sickness;
	}


	public Patient() {
		
	}


	public Patient(String firstName, String lastName, String city, int sufferFrom) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.sufferFrom = sufferFrom;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Timestamp getJoining() {
		return joining;
	}


	public void setJoining(Timestamp joining) {
		this.joining = new Timestamp(
		        ZonedDateTime.of(2016, 8, 25, 11, 23, 46, 0, 
		                ZoneId.of("UTC")
		            ).toInstant().toEpochMilli());
	}


	public int getSufferFrom() {
		return sufferFrom;
	}


	public void setSufferFrom(int sufferFrom) {
		this.sufferFrom = sufferFrom;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public CareTaker getCareTaker() {
		return careTaker;
	}


	public void setCareTaker(CareTaker careTaker) {
		this.careTaker = careTaker;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", joining=" + joining + ", sufferFrom=" + sufferFrom + ", doctor=" + doctor + ", careTaker="
				+ careTaker + "]";
	}
	
	
	public void addSickness(Sickness tempSickness) {
		if(sickness==null) {
			sickness=new ArrayList<>();
		}
		
		sickness.add(tempSickness);
	}

	//define the fields
	
	//generate getters and setters along with the constructers, toString method.
	
	// add convience method if needed
	
	// annotate the fields with appropriate columns from the db
	
	
}
