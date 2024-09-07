package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.MedOrderDao;
import com.shaif.hospital.dto.MedOrder;

public class MedOrderDaoImp implements MedOrderDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();


	@Override
	public MedOrder saveMedOrder(MedOrder medOrder, int eid) {
		MedOrder medOrder1=em.find(MedOrder.class, eid);
		if (medOrder1 != null) {
            tx.begin();
            medOrder1.setDname(medOrder.getDname());
            medOrder1.setDate(medOrder.getDate());
            medOrder1.setTotal(medOrder.getTotal());
            tx.commit();
            return medOrder1;
		}
		return null;
	}

	@Override
	public MedOrder getMedOrderById(int mid) {
		MedOrder medOrder=em.find(MedOrder.class, mid);
		if (medOrder != null) {
			tx.begin();
			tx.commit();
			return medOrder;
		}
		return null;
	}

	@Override
	public List<MedOrder> getAllMedOrders() {
		List<MedOrder> medOrders=em.createQuery("from MedOrder",MedOrder.class).getResultList();
		if (medOrders != null) {
            tx.begin();
            tx.commit();
            return medOrders;
		}
		return null;
	}

	@Override
	public boolean deleteMedOrderById(int mid) {
		MedOrder medOrder=em.find(MedOrder.class, mid);
		if (medOrder != null) {
			tx.begin();
			em.remove(medOrder);
			tx.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<MedOrder> getMedOrdersByDoctorName(String name) {
		List<MedOrder> medOrders=em.createQuery("select m from MedOrder m where m.dname=:name",MedOrder.class).setParameter("name", name).getResultList();
		
		if (medOrders != null) {
			tx.begin();
			tx.commit();
			return medOrders;
		}
		return null;
	}

	@Override
	public List<MedOrder> getMedOrderByDate(String date) {
		List<MedOrder> medOrders=em.createQuery("select m from MedOrder m where m.date=:date",MedOrder.class).setParameter("date", date).getResultList();
		if (medOrders != null) {
			tx.begin();
			tx.commit();
			return medOrders;
		}
		return null;
	}

	@Override
	public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
		MedOrder medOrder1=em.find(MedOrder.class, mid);
		if (medOrder1 != null) {
			tx.begin();
			medOrder1.setDname(medOrder.getDname());
			medOrder1.setDate(medOrder.getDate());
			medOrder1.setTotal(medOrder.getTotal());
			tx.commit();
			return medOrder1;
		}
		return null;
	}

}
