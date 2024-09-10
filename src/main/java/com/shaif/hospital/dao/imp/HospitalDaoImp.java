package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.HospitalDao;
import com.shaif.hospital.dto.Hospital;

public class HospitalDaoImp implements HospitalDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	
	@Override
	public Hospital saveHospital(Hospital hospital) {
		tx.begin();
		em.persist(hospital);
		tx.commit();
		return hospital;
	}

	@Override
	public Hospital getHospital(int id) {
		tx.begin();
		Hospital hospital=em.find(Hospital.class, id);
		if(hospital!=null) {
			tx.commit();
			return hospital;
		}
		return null;
	}

	@Override
	public Hospital updateHospital(int hid, Hospital hospital) {
		tx.begin();
		Hospital hospital1=em.find(Hospital.class, hid);
		if(hospital1!=null) {
			hospital1.setName(hospital.getName());
			hospital1.setWebsite(hospital.getWebsite());
			em.merge(hospital1);
			tx.commit();
			return hospital1;
		}
		return hospital;
	}

	@Override
	public boolean deleteHospital(int id) {
		Hospital hospital=em.find(Hospital.class, id);
		if(hospital!=null) {
			tx.begin();
			em.remove(hospital);
			tx.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Hospital> getAllHospitals() {
		List<Hospital> hospitals=em.createQuery("from Hospital").getResultList();
		if (hospitals != null) {
			return hospitals;
		}
		return null;
	}
	
}
