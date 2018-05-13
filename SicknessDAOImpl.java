package com.krishnas.hms.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;
import com.krishnas.hms.entity.SicknessDescription;

@Repository
public class SicknessDAOImpl implements SicknessDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Sickness> listSickness() {
		System.out.println("Inside DAO method");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session created");

		Query<Sickness> query = session.createQuery("from Sickness order by title", Sickness.class);
		System.out.println("Query generated");

		List<Sickness> sickness = query.getResultList();
		System.out.println("got result");
		System.out.println(sickness);
		return sickness;
	}

	@Override
	public void saveSickness(Sickness sickness, SicknessDescription sDesc) {
		Session session = sessionFactory.getCurrentSession();

		sickness.setSicknessDescription(sDesc);

		session.persist(sickness);

		System.out.println("well done");
	}

	@Override
	public List<Sickness> listDoctorSickness(int id) {
		Session session = sessionFactory.getCurrentSession();

		Doctor tempDoctor = session.get(Doctor.class, id);

		System.out.println(tempDoctor);

		List<Sickness> sickness = tempDoctor.getSickness();
		
		Collections.sort(sickness, new Comparator<Sickness>() {

			@Override
			public int compare(Sickness o1, Sickness o2) {
				
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		   
			

		System.out.println(sickness);
		return sickness;
	}

	@Override
	public List<Sickness> getParentSickness(Patient patient) {
		Session session = sessionFactory.getCurrentSession();
		Patient tempPatient = session.get(Patient.class, patient.getId());
		List<Sickness> sickness = tempPatient.getSickness();
		System.out.println(sickness);
		return sickness;
	}

	@Override
	public Sickness getSicknessDetails(int id) {
		Session session = sessionFactory.getCurrentSession();

		Sickness tempSickness = session.get(Sickness.class, id);
		System.out.println(tempSickness);
		return tempSickness;
	}

	@Override
	public SicknessDescription getSicknessDescription(Sickness sickness) {
		Session session = sessionFactory.getCurrentSession();

		int id = sickness.getId();
		Sickness tempSickness = session.get(Sickness.class, id);
		SicknessDescription tempSicknessDescription = tempSickness.getSicknessDescription();
		System.out.println(tempSicknessDescription);
		return tempSicknessDescription;
	}
	
	
	
	@Override
	public void updateSickness(Sickness sickness, SicknessDescription sicknessDescription) {
		Session session = sessionFactory.getCurrentSession();

		int id = sickness.getId();
		Sickness tempSickness = session.get(Sickness.class, id);
		tempSickness.setTitle(sickness.getTitle());
		SicknessDescription tempSicknessDescription = tempSickness.getSicknessDescription();
		System.out.println(tempSicknessDescription);
		if (tempSicknessDescription != null) {
			session.delete(tempSicknessDescription);
		}
		SicknessDescription sd = new SicknessDescription(sicknessDescription.getDescription(), sicknessDescription.getSymptoms());
		tempSickness.setSicknessDescription(sd);
		System.out.println(sicknessDescription);
		System.out.println(tempSickness);
		System.out.println("sd: "+sd);
		System.out.println("ok upto here");
		session.persist(tempSickness);
	}

	@Override
	public List<Doctor> getDoctorSickness(int id) {
		Session session = sessionFactory.getCurrentSession();
		Sickness sickness = session.get(Sickness.class, id);
		List<Doctor> doctorList = sickness.getDoctors(); 
		System.out.println(doctorList);
		return doctorList;
	}

	@Override
	public void addDoctorToSickness(int sick_id, int doc_id) {
	Session session = sessionFactory.getCurrentSession();
	
	Sickness sickness = session.get(Sickness.class, sick_id);
	Doctor doctor= session.get(Doctor.class, doc_id);
	
	sickness.addDoctor(doctor);
	System.out.println(sickness.getDoctors());
	session.save(sickness);
		
	}

	@Override
	public List<Patient> getSicknessPatients(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Sickness sickness = session.get(Sickness.class, id);
		List<Patient> patients = sickness.getPatients();
		System.out.println(patients);
		return patients;
	}

}
