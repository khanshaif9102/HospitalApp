package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.ItemsDao;
import com.shaif.hospital.dto.Item;
import com.shaif.hospital.dto.MedOrder;

public class ItemsDaoImp implements ItemsDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();

	@Override
	public Item saveItem(int mid, Item item) {
		MedOrder medOrder=em.find(MedOrder.class, mid);
		if (medOrder != null) {
			tx.begin();
			em.persist(item);
			tx.commit();
			return item;
		}
		return null;
	}

	@Override
	public Item getItemById(int mid) {
		Item item=em.find(Item.class, mid);
		if (item != null) {
			tx.begin();
			tx.commit();
			return item;
		}
		return null;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> items=em.createQuery("from Item",Item.class).getResultList();
		if (items != null) {
            tx.begin();
            tx.commit();
            return items;
		}
		return null;
	}

	@Override
	public boolean deleteItemById(int aid) {
		Item item=em.find(Item.class, aid);
		if (item != null) {
			tx.begin();
			em.remove(item);
			tx.commit();
			return true;
		}
		return false;
	}
	

}
