package com.krishnas.hms.service;

import java.util.List;

import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;
import com.krishnas.hms.entity.SicknessDescription;

public interface SicknessService {
	
	public List<Sickness> listSickness();

	public void saveSickness(Sickness sickness, SicknessDescription sDesc);

	public Sickness getSicknessDetails(int id);

	public SicknessDescription getSicknessDescription(Sickness sickness);

	public void updateSickness(Sickness sickness, SicknessDescription sicknessDescription);

	public List<Doctor> getSicknessDoctors(int id);

	public void addDoctorToSickness(int sick_id, int doc_id);

	public List<Patient> getSicknessPatients(int id);

}
