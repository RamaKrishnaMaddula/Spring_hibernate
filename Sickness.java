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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sickness")
public class Sickness {
	
	//Annotate class with entity and table
	
	
	
	//define fields 
	
	//generate getters and setters along with constructers and toString method
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="desc_id")
	private SicknessDescription  sicknessDescription;
	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="doctor_sickness",
			  joinColumns=@JoinColumn(name="sick_id"),
			  inverseJoinColumns=@JoinColumn(name="doc_id"))
	private List<Doctor> doctors;
	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="sickness_patient",
			  joinColumns=@JoinColumn(name="sick_id"),
			  inverseJoinColumns=@JoinColumn(name="pat_id"))
	private List<Patient> patients;
	
	
	
	
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Sickness() {
		
	}

	public Sickness(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Sickness [id=" + id + ", title=" + title + ", sicknessDescription=" + sicknessDescription + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SicknessDescription getSicknessDescription() {
		return sicknessDescription;
	}

	public void setSicknessDescription(SicknessDescription sicknessDescription) {
		this.sicknessDescription = sicknessDescription;
	}
	
	public void addPatient(Patient tempPatient) {
		if(patients == null) {
			patients = new ArrayList<> ();
			}
		patients.add(tempPatient);

	}
	
	public void addDoctor(Doctor tempDoctor) {
		if(doctors == null) {
			doctors = new ArrayList<> ();
			}
		doctors.add(tempDoctor);
		
	}
	
	//annotate fields with the columns in db
	
	//create the convenience methods

}
