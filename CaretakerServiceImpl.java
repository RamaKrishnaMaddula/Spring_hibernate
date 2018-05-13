package com.krishnas.hms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishnas.hms.dao.CaretakerDAO;
import com.krishnas.hms.entity.CareTaker;
import com.krishnas.hms.entity.Patient;

@Service
public class CaretakerServiceImpl implements CaretakerService {
	
	@Autowired
	private CaretakerDAO caretakerDAO;

	@Override
	@Transactional
	public List<CareTaker> listCaretaker() {
		return caretakerDAO.listCaretaker();
	}

	@Override
	@Transactional
	public void saveCareTaker(CareTaker caretaker) {

		caretakerDAO.saveCareTaker(caretaker);
		
		
	}

	@Override
	@Transactional
	public CareTaker getCaretakerDetails(int id) {
		
		return caretakerDAO.getCaretakerDetails(id);
	}

	@Override
	@Transactional
	public int updateCaretaker(CareTaker caretaker) {
		
		return caretakerDAO.updateCaretaker(caretaker);
	}

	@Override
	@Transactional
	public List<Patient> getCaretakerPatients(int id) {
		
		return caretakerDAO.getCaretakerPatients(id);
	}

}
