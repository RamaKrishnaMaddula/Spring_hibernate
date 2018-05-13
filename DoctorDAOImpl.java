package com.krishnas.hms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.DoctorDetail;
import com.krishnas.hms.entity.Patient;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Doctor> listDoctors() {
		System.out.println("Reached doctorDAO");

		Session session = sessionFactory.getCurrentSession();

		System.out.println("session created ");

		Query<Doctor> theQuery = session.createQuery("from Doctor order by lastName", Doctor.class);

		System.out.println("Query created");

		// execute the query and retrieve the result set

		List<Doctor> doctors = theQuery.getResultList();

		System.out.println(doctors);

		// return the list of customers

		return doctors;
	}

	@Override
	public Doctor saveDoctor(Doctor theDoctor) {
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("going to save doctor");
		session.save(theDoctor);
		System.out.println("doctor got saved");
		return theDoctor;
	}

	@Override
	public void addDoctorDetails(int id, DoctorDetail doctorDetail) {
		Session session = sessionFactory.getCurrentSession();
		
		Doctor theDoctor = session.get(Doctor.class, id);
		
		System.out.println(theDoctor);
		System.out.println(doctorDetail);
		
		theDoctor.setDoctorDetail(doctorDetail);
		session.save(doctorDetail);
		System.out.println("Additional details stored");
	}

	@Override
	public Doctor getDoctorDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Doctor doctor = session.get(Doctor.class, id);
		System.out.println(doctor);
		return doctor;
	}

	@Override
	public DoctorDetail getDoctorContact(Doctor theDoctor) {
		Session session = sessionFactory.getCurrentSession();
		int id = theDoctor.getId();
		Doctor tempDoctor = session.get(Doctor.class, id); 
		System.out.println("getting doctor extra details");
		DoctorDetail doctorDetail = tempDoctor.getDoctorDetail();
		System.out.println(tempDoctor);
		System.out.println(doctorDetail);
		System.out.println("got the details");
		
		return doctorDetail;
	}

	@Override
	public void updateDoctorDetail(Doctor doctor, DoctorDetail doctorDetail) {
		Session session = sessionFactory.getCurrentSession();
		
		String contact = doctorDetail.getContact();
		String qualification = doctorDetail.getQualification();
		DoctorDetail tempDoctorDetail = new DoctorDetail(contact,qualification);
		
		int id = doctor.getId();
		Doctor tempDoctor = session.get(Doctor.class, id);
		DoctorDetail delDoctorDetail = tempDoctor.getDoctorDetail();
		if(delDoctorDetail != null) {
		session.delete(delDoctorDetail);
		}
		tempDoctor.setFirstName(doctor.getFirstName());
		tempDoctor.setLastName(doctor.getLastName());
		tempDoctor.setEmail(doctor.getEmail());
		tempDoctor.setDoctorDetail(tempDoctorDetail);
		session.persist(tempDoctor);
		
		
	}

	@Override
	public void deleteDoctor(int id) {
		Session session = sessionFactory.getCurrentSession();
		
      
		Doctor doctor = session.get(Doctor.class, id);
		  List<Patient> patients = doctor.getPatients();
		  if(patients != null) {
			  
			  for(Patient tempPatient : patients) {
				  System.out.println("going through");
				  tempPatient.setDoctor(null);
			  }
		  }
		session.delete(doctor);
		System.out.println("Doctor deleted succesfully");
		
	}

}
