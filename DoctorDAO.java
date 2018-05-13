package com.krishnas.hms.dao;

import java.util.List;

import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.DoctorDetail;

public interface DoctorDAO {
	
	public List<Doctor> listDoctors();

	public Doctor saveDoctor(Doctor theDoctor);

	public void addDoctorDetails(int id, DoctorDetail doctorDetail);

	public Doctor getDoctorDetail(int id);

	public DoctorDetail getDoctorContact(Doctor theDoctor);

	public void updateDoctorDetail(Doctor doctor, DoctorDetail doctorDetail);

	public void deleteDoctor(int id);

}
