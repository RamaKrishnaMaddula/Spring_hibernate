package com.krishnas.hms.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krishnas.hms.entity.CareTaker;
import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> listPatients() {
		
		System.out.println("At PatientDAO");
		
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("session created");
		
		Query<Patient> query = session.createQuery("from Patient order by lastName",Patient.class);
		
		System.out.println("query created");
		
		List<Patient> patients = query.getResultList();
		
		System.out.println("list got");
		
		System.out.println(patients);
		
		return patients;
	}

	@Override
	public Patient savePatient(Patient thePatient) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("gonna save the patient");
		session.save(thePatient);
		System.out.println("patient saved");
		System.out.println(thePatient);
		return thePatient;
	}

	@Override
	public void additionalPatientDetails(int p_id,int[] s_id, int d_id, int c_id) {
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Patient id: "+p_id);
		System.out.println("Sickness id: "+s_id);
		System.out.println("Doctor id: "+d_id);
		System.out.println("Care taker id: "+c_id);
		
		
		Doctor doctor = session.get(Doctor.class, d_id);
		CareTaker careTaker = session.get(CareTaker.class, c_id);
		Patient patient = session.get(Patient.class, p_id);
		for (int i = 0; i < s_id.length; i++) {
			Sickness sickness = session.get(Sickness.class, s_id[i]);
			patient.addSickness(sickness);
		}
		
		patient.setCareTaker(careTaker);
		patient.setDoctor(doctor);
		
		session.persist(patient);
		
		System.out.println(patient);
		
	}

	@Override
	public List<Patient> getDoctorPatients(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Doctor tempDoctor = session.get(Doctor.class, id);
		System.out.println(tempDoctor);
		List<Patient> doctorPatients = tempDoctor.getPatients();
		//System.out.println(doctorPatients);
		Collections.sort(doctorPatients, new Comparator<Patient>() {

			@Override
			public int compare(Patient o1, Patient o2) {
				
				return o1.getFirstName().compareTo(o2.getFirstName());
			}

			
		});
		return doctorPatients;
	}

	@Override
	public Patient getPatientDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Patient tempPatient = session.get(Patient.class, id);
		System.out.println(tempPatient);
		return tempPatient;
	}

	@Override
	public CareTaker getPatientCaretaker(Patient patient) {
		Session session = sessionFactory.getCurrentSession();
		
		Patient tempPatient = session.get(Patient.class, patient.getId());
		CareTaker caretaker = tempPatient.getCareTaker();
		System.out.println(caretaker.getFirstName());
		return caretaker;
	}

	@Override
	public Doctor getPatientDoctor(Patient patient) {
		Session session = sessionFactory.getCurrentSession();
		Patient tempPatient = session.get(Patient.class, patient.getId());
		Doctor doctor = tempPatient.getDoctor();
		return doctor;
	}

	@Override
	public void updatePatient(Patient patient, int pat_id, int doc_id, int c_id) {
		System.out.println("in  patientDAOImpl");
		Session session = sessionFactory.getCurrentSession();
		
		Patient tempPatient = session.get(Patient.class, pat_id);
		Doctor tempDoctor = session.get(Doctor.class, doc_id);
		CareTaker tempCaretaker = session.get(CareTaker.class, c_id);
		
		
		tempPatient.setFirstName(patient.getFirstName());
		tempPatient.setLastName(patient.getLastName());
		tempPatient.setCity(patient.getCity());
		tempPatient.setDoctor(tempDoctor);
		tempPatient.setCareTaker(tempCaretaker);
		
		session.persist(tempPatient);
	}

	@Override
	public void addPatientToDoctor(int pat_id, int doc_id) {
	    Session session = sessionFactory.getCurrentSession();
	    
	    Patient patient  = session.get(Patient.class, pat_id);
	    Doctor doctor = session.get(Doctor.class, doc_id);
	    patient.setDoctor(doctor);
	    session.persist(patient);
		
	}

	@Override
	public void addPatientToSickness(int pat_id, int sick_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Patient patient = session.get(Patient.class, pat_id);
		Sickness sickness = session.get(Sickness.class, sick_id);
		patient.addSickness(sickness);
		session.persist(patient);
	}

	@Override
	public void addPatientToCaretaker(int ctaker_id, int pat_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Patient patient = session.get(Patient.class, pat_id);
		CareTaker  caretaker = session.get(CareTaker.class, ctaker_id);
		
		patient.setCareTaker(caretaker);
		
		session.persist(patient);
	}

}
