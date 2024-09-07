package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.ObservationDao;
import com.shaif.hospital.dto.Encounter;
import com.shaif.hospital.dto.Observation;

public class ObservationDaoImp implements ObservationDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	
	@Override
	public Observation saveObservation(Observation observation, int eid) {
		Encounter encounter=em.find(Encounter.class, eid);
		if (encounter != null) {
			tx.begin();
			em.persist(observation);
			tx.commit();
			return observation;
		}
		return null;
	}
	@Override
	public Observation getObservationById(int oid) {
		Observation observation=em.find(Observation.class, oid);
		if (observation != null) {
			tx.begin();
			tx.commit();
			return observation;
		}
		return null;
	}
	@Override
	public List<Observation> getAllObservations() {
		List<Observation> observations=em.createQuery("from Observation",Observation.class).getResultList();
		if (observations != null) {
			tx.begin();
			tx.commit();
			return observations;
		}
		return null;
	}
	@Override
	public boolean deleteObservationById(int oid) {
		Observation observation=em.find(Observation.class, oid);
		if (observation != null) {
            tx.begin();
            em.remove(observation);
            tx.commit();
            return true;
		}
		return false;
	}
	@Override
	public List<Observation> getObservationByDoctorName(String name) {
		List<Observation> observations=em.createQuery("from Observation where doctorName=:name",Observation.class).setParameter("name", name).getResultList();
		if (observations != null) {
			tx.begin();
			tx.commit();
			return observations;
		}
		return null;
	}
	@Override
	public Observation updateObservationById(int oid, Observation observation) {
		Observation observation2=em.find(Observation.class, oid);
		if (observation2 != null) {
			tx.begin();
			observation2.setDname(observation.getDname());
			observation2.setRobservation(observation.getRobservation());
			tx.commit();
			return observation2;
		}
		return null;
	}
	
}
