package com.krishnas.hms.dao;

import java.util.List;

import com.krishnas.hms.entity.CareTaker;
import com.krishnas.hms.entity.Patient;

public interface CaretakerDAO {

	
	public List<CareTaker> listCaretaker();

	public void saveCareTaker(CareTaker caretaker);

	public CareTaker getCaretakerDetails(int id);

	public int updateCaretaker(CareTaker caretaker);

	public List<Patient> getCaretakerPatients(int id);

}
