package com.krishnas.hms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishnas.hms.dao.SicknessDAO;
import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;
import com.krishnas.hms.entity.SicknessDescription;

@Service
public class SicknessServiceImpl implements SicknessService {

	@Autowired
	private SicknessDAO sicknessDAO;
	
	@Override
	@Transactional
	public List<Sickness> listSickness() {
		System.out.println("At service method");
		return sicknessDAO.listSickness();
	}

	@Override
	@Transactional
	public void saveSickness(Sickness sickness, SicknessDescription sDesc) {
	
		sicknessDAO.saveSickness(sickness,sDesc);
		
	}

	@Override
	@Transactional
	public Sickness getSicknessDetails(int id) {
		
		return sicknessDAO.getSicknessDetails(id);
	}

	@Override
	@Transactional
	public SicknessDescription getSicknessDescription(Sickness sickness) {
		
		return sicknessDAO.getSicknessDescription(sickness);
	}

	@Override
	@Transactional
	public void updateSickness(Sickness sickness, SicknessDescription sicknessDescription) {
		
	    sicknessDAO.updateSickness(sickness,sicknessDescription);
	}

	@Override
	@Transactional
	public List<Doctor> getSicknessDoctors(int id) {
		
		return sicknessDAO.getDoctorSickness(id);
	}

	@Override
	@Transactional
	public void addDoctorToSickness(int sick_id, int doc_id) {
		sicknessDAO.addDoctorToSickness(sick_id,doc_id);
	}

	@Override
	@Transactional
	public List<Patient> getSicknessPatients(int id) {
		
		return sicknessDAO.getSicknessPatients(id);
	}

}
