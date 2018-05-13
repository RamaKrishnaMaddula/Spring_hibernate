package com.krishnas.hms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krishnas.hms.entity.CareTaker;
import com.krishnas.hms.entity.Patient;

@Repository
public class CaretakerDAOImpl implements CaretakerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CareTaker> listCaretaker() {
		Session session = sessionFactory.getCurrentSession();

		System.out.println("session created ");

		Query<CareTaker> theQuery = session.createQuery("from CareTaker order by lastName", CareTaker.class);

		System.out.println("Query created");

		// execute the query and retrieve the result set

		List<CareTaker> caretakers = theQuery.getResultList();

		System.out.println(caretakers);

		// return the list of customers

		return caretakers;	}

	@Override
	public void saveCareTaker(CareTaker caretaker) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(caretaker);
		
	}

	@Override
	public CareTaker getCaretakerDetails(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		CareTaker caretaker = session.get(CareTaker.class, id);
						return caretaker;
	}

	@Override
	public int updateCaretaker(CareTaker caretaker) {
		
		Session session = sessionFactory.getCurrentSession();
		CareTaker tempCaretaker = session.get(CareTaker.class, caretaker.getId());
		tempCaretaker.setFirstName(caretaker.getFirstName());
		tempCaretaker.setLastName(caretaker.getLastName());
		tempCaretaker.setExperiance(caretaker.getExperiance());
		session.save(tempCaretaker);
		
		return tempCaretaker.getId();
	}

	@Override
	public List<Patient> getCaretakerPatients(int id) {
		Session session = sessionFactory.getCurrentSession();
		
	    CareTaker caretaker = session.get(CareTaker.class, id);
	    
	    List<Patient> caretakerPatients = caretaker.getPatients();
	    System.out.println(caretakerPatients);
		return caretakerPatients;
	}

}
