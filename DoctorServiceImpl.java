package com.krishnas.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnas.hms.dao.DoctorDAO;
import com.krishnas.hms.dao.PatientDAO;
import com.krishnas.hms.dao.SicknessDAO;
import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.DoctorDetail;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDAO doctorDAO;
	
	@Autowired
	private PatientDAO patientDAO; 
	
	@Autowired
	private SicknessDAO sicknessDAO;

	@Override
	@Transactional
	public List<Doctor> listDoctors() {
		System.out.println("reached doctorservice method");
		return doctorDAO.listDoctors();
	}

	@Override
	@Transactional
	public Doctor saveDoctor(Doctor theDoctor) {
		return doctorDAO.saveDoctor(theDoctor);
		}

	@Override
	@Transactional
	public void addDoctorDetails(int id, DoctorDetail doctorDetail) {
		doctorDAO.addDoctorDetails(id,doctorDetail);
	}

	@Override
	@Transactional 
	public Doctor getDoctorDetail(int id) {
		
		
		return doctorDAO.getDoctorDetail(id);
	}

	@Override
	@Transactional
	public DoctorDetail getDoctorContact(Doctor theDoctor) {
		
		return doctorDAO.getDoctorContact(theDoctor);
	}

	@Override
	@Transactional
	public List<Patient> getDoctorPatients(int id) {
		
		return patientDAO.getDoctorPatients(id);
	}

	@Override
	@Transactional
	public List<Sickness> listDoctorSickness(int id) {
		
		return sicknessDAO.listDoctorSickness(id);
	}

	@Override
	@Transactional
	public void updateDoctorDetail(Doctor doctor, DoctorDetail doctorDetail) {
		doctorDAO.updateDoctorDetail(doctor,doctorDetail);
	}

	@Override
	@Transactional
	public void deleteDoctor(int id) {
		doctorDAO.deleteDoctor(id);
		
	}



}
