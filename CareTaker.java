package com.krishnas.hms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="care_taker")
public class CareTaker {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="experiance")
	private int experiance;
	
	@OneToMany(mappedBy="careTaker",
			cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Patient> patients;
	
	
	public CareTaker() {
		
	}
	//Annotate class with entity and table


	public CareTaker(String firstName, String lastName, int experiance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.experiance = experiance;
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


	public int getExperiance() {
		return experiance;
	}


	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}


	public List<Patient> getPatients() {
		return patients;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	public void addPatient(Patient tempPatient) {
		if(patients == null) {
			patients = new ArrayList<> ();
		}
		patients.add(tempPatient);
		
		tempPatient.setCareTaker(this);
	}
	//define the fields
	
	//generate constructors and getters and setters methods
	
	//generate toString()
	
	//annotate fields with appropriate column names 
	
	//add convinienence  method
}
