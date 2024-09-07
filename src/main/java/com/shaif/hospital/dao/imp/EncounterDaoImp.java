package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.EncounterDao;
import com.shaif.hospital.dto.Branch;
import com.shaif.hospital.dto.Encounter;

public class EncounterDaoImp implements EncounterDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	
	@Override
	public Encounter saveEncounter(Encounter encounter, int bid) {
		Branch branch=em.find(Branch.class, bid);
		if (branch != null) {
			tx.begin();
			em.persist(encounter);
			tx.commit();
			return encounter;
		}
		return null;
	}

	@Override
	public Encounter getEncounterById(int eid) {
		Encounter encounter=em.find(Encounter.class, eid);
        if (encounter != null) {
            tx.begin();
            tx.commit();
            return encounter;
        }
        return null;
	}

	@Override
	public List<Encounter> getAllEncounters() {
		List<Encounter> encounters=em.createQuery("from Encounter",Encounter.class).getResultList();
		if (encounters != null) {
			tx.begin();
			tx.commit();
			return encounters;
		}
		return null;
	}

	@Override
	public Encounter updateEncounterById(int eid, Encounter encounter) {
		Encounter encounter1=em.find(Encounter.class, eid);
		if (encounter1 != null) {
			tx.begin();
			encounter1.setDateJoin(encounter.getDateJoin());
			encounter1.setDisharge(encounter.getDisharge());
			tx.commit();
			return encounter1;
		}
		return null;
	}

	@Override
	public boolean deleteEncounterById(int eid) {
		Encounter encounter=em.find(Encounter.class, eid);
		if (encounter != null) {
			tx.begin();
			em.remove(encounter);
			tx.commit();
			return true;
		}
		return false;
	}

}
