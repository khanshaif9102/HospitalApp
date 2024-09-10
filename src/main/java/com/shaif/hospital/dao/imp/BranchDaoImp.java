package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.BranchDao;
import com.shaif.hospital.dto.Branch;
import com.shaif.hospital.dto.Hospital;

public class BranchDaoImp implements BranchDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	
	@Override
	public Branch saveBranch(int hid, Branch branch) {
		Hospital hospital=em.find(Hospital.class, hid);
		if(hospital!=null) {
			tx.begin();
			em.persist(branch);
			tx.commit();
			return branch;
		}
		return null;
	}

	@Override
	public boolean deleteBranch(int bid) {
		Branch branch=em.find(Branch.class, bid);
		if(branch!=null) {
			tx.begin();
			em.remove(branch);
			tx.commit();
			return true;
		}
		return false;
	}

	@Override
	public Branch getBranchById(int bid) {
		Branch branch=em.find(Branch.class, bid);
		if(branch!=null) {
			tx.begin();
			tx.commit();
			return branch;
		}
		return null;
	}

	@Override
	public Branch updateBranchById(int bid, Branch branch) {
		Branch branch1=em.find(Branch.class, bid);
		if(branch1!=null) {
			tx.begin();
			branch1.setName(branch.getName());
			branch1.setAddresses(branch.getAddresses());
			branch1.setPhno(branch.getPhno());
			branch1.setEmail(branch.getEmail());
			em.merge(branch1);
			tx.commit();
			return branch1;
		}
		return null;
	}

	@Override
	public List<Branch> getAllBranches() {
		List<Branch> branches=em.createQuery("from Branch",Branch.class).getResultList();
		if(branches!=null) {
            tx.begin();
            tx.commit();
            return branches;
		}
		return null;
	}

}
