package com.krishnas.hms.dao;

import java.util.List;

import com.krishnas.hms.entity.CareTaker;
import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.Patient;

public interface PatientDAO {

	public List<Patient> listPatients();

	public Patient savePatient(Patient thePatient);

	public void additionalPatientDetails(int p_id, int[] s_id, int d_id, int c_id);

	public List<Patient> getDoctorPatients(int id);

	public Patient getPatientDetail(int id);

	public CareTaker getPatientCaretaker(Patient patient);

	public Doctor getPatientDoctor(Patient patient);

	public void updatePatient(Patient patient, int pat_id, int sick_id, int doc_id);

	public void addPatientToDoctor(int pat_id, int doc_id);

	public void addPatientToSickness(int pat_id, int sick_id);

	public void addPatientToCaretaker(int ctaker_id, int pat_id);

	}

   
