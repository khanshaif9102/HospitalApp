package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.UserDao;
import com.shaif.hospital.dto.User;

public class UserDaoImp implements UserDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	@Override
	public User saveUser(User user) {
		tx.begin();
		em.persist(user);
		tx.commit();
		return user;
	}
	@Override
	public User getUserById(int uid) {
		User user=em.find(User.class, uid);
		if (user != null) {
			tx.begin();
			tx.commit();
			return user;
		}
		return null;
	}
	@Override
	public List<User> getAllUsers() {
		List<User> users=em.createQuery("from User",User.class).getResultList();
		if (users != null) {
			tx.begin();
			tx.commit();
			return users;
		}
		return null;
	}
	@Override
	public User getUserByUserName(String userName) {
		User user=em.find(User.class, userName);
		if (user != null) {
			tx.begin();
			tx.commit();
			return user;
		}
		return null;
	}
	@Override
	public User getUserByRole(String role) {
		User user=em.find(User.class, role);
		if (user != null) {
			tx.begin();
			tx.commit();
			return user;
		}
		return null;
	}
	@Override
	public boolean deleteUserById(int uid) {
		User user=em.find(User.class, uid);
		if (user != null) {
			tx.begin();
			em.remove(user);
			tx.commit();
			return true;
		}
		return false;
	}
	
	

}
