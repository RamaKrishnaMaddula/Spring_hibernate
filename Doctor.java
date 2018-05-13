package com.krishnas.hms.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	
	
	//annotate class with entity
	
	//annotate class with table
	
	//define appropriate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="doctor_detail_id")
	private DoctorDetail doctorDetail;
	
	
	@OneToMany(mappedBy="doctor",
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Patient> patients;
	
	public List<Sickness> getSickness() {
		return sickness;
	}


	public void setSickness(List<Sickness> sickness) {
		this.sickness = sickness;
	}

	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="doctor_sickness",
			  joinColumns=@JoinColumn(name="doc_id"),
			  inverseJoinColumns=@JoinColumn(name="sick_id"))
	private List<Sickness> sickness;
	
	//create constructors
	
	public List<Patient> getPatients() {
		return patients;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}


	public Doctor() {
		
	}


	public Doctor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	//generate getters and setters
	
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public DoctorDetail getDoctorDetail() {
		return doctorDetail;
	}


	public void setDoctorDetail(DoctorDetail doctorDetail) {
		this.doctorDetail = doctorDetail;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public void addPatient(Patient tempPatient) {
		if(patients == null) {
			patients = new ArrayList<>();
		}
		
		patients.add(tempPatient);
		
		tempPatient.setDoctor(this);
	}
	
	
	//generate toString method
	
	//annotate fields with appropriate columns in doctor table in the db
	
    //annotate relations and cascade types.

}
