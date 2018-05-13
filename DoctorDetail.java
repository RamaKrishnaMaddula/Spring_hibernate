package com.krishnas.hms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctor_detail")
public class DoctorDetail {

	
	//Annotate class with entity and table
	
	//define appropriate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="qualification")
	private String qualification;
	
	@OneToOne(mappedBy="doctorDetail",
			cascade= {CascadeType.DETACH,CascadeType.MERGE,
					CascadeType.PERSIST,CascadeType.REFRESH})
	private Doctor doctor;

	
	public DoctorDetail() {
		
	}
	
	public DoctorDetail(String contact, String qualification) {
		this.contact = contact;
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return "DoctorDetail [id=" + id + ", contact=" + contact + ", Qualification=" + qualification + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
	//generate constructor and getters and setters
	
	//generate toString method
	
	//annotate fields with appropriate columns in the database.
	
	//define relations and cascade type
}
