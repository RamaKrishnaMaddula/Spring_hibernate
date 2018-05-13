package com.krishnas.hms.service;

import java.util.List;

import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.DoctorDetail;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;

public interface DoctorService {

	
	public List<Doctor> listDoctors();

	public Doctor saveDoctor(Doctor theDoctor);

	public void addDoctorDetails(int id, DoctorDetail doctorDetail);

	public Doctor getDoctorDetail(int id);

	public DoctorDetail getDoctorContact(Doctor theDoctor);

	public List<Patient> getDoctorPatients(int id);

	public List<Sickness> listDoctorSickness(int id);

	public void updateDoctorDetail(Doctor doctor, DoctorDetail doctorDetail);

	public void deleteDoctor(int id);

}
