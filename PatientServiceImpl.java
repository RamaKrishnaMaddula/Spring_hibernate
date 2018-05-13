package com.krishnas.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnas.hms.dao.PatientDAO;
import com.krishnas.hms.dao.SicknessDAO;
import com.krishnas.hms.entity.CareTaker;
import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDAO patientDAO ;
	
	@Autowired
	private SicknessDAO sicknessDAO;

	@Override
	@Transactional
	public List<Patient> listPatients() {
		
		System.out.println("At PatientService class");
		return patientDAO.listPatients();
	}

	@Override
	@Transactional
	public Patient savePatient(Patient thePatient) {
		return patientDAO.savePatient(thePatient);
		
	}

	@Override
	@Transactional
	public void additionalPatientDetails(int p_id,int[] s_id, int d_id, int c_id) {
		patientDAO.additionalPatientDetails(p_id,s_id,d_id,c_id);
		
	}

	@Override
	@Transactional
	public Patient getPatientDetail(int id) {
		
		return patientDAO.getPatientDetail(id);
	}

	@Override
	@Transactional
	public List<Sickness> getPatientSickness(Patient patient) {
		
		return sicknessDAO.getParentSickness(patient);
				}

	@Override
	@Transactional
	public CareTaker getPatientCaretaker(Patient patient) {
		
		return patientDAO.getPatientCaretaker(patient);
	}

	@Override
	@Transactional
	public Doctor getPatientDoctor(Patient patient) {
		
		return patientDAO.getPatientDoctor(patient);
	}

	@Override
	@Transactional
	public void updatePatient(Patient patient, int pat_id,  int doc_id, int c_id) {
		
		System.out.println("in patientServiceimpl");
		patientDAO.updatePatient(patient,pat_id,doc_id,c_id);
		
	}

	@Override
	@Transactional
	public void addPatientToDoctor(int pat_id, int doc_id) {
		
		patientDAO.addPatientToDoctor(pat_id,doc_id);
	}

	@Override
	@Transactional
	public void addPatientToSickness(int pat_id, int sick_id) {
	
		patientDAO.addPatientToSickness(pat_id,sick_id);
	}

	@Override
	@Transactional
	public void addPatientToCaretaker(int ctaker_id, int pat_id) {
		patientDAO.addPatientToCaretaker(ctaker_id,pat_id);
		
	}

	
	
	

}
