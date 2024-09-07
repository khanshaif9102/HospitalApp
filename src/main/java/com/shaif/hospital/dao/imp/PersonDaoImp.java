package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.PersonDao;
import com.shaif.hospital.dto.Person;

public class PersonDaoImp implements PersonDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	
	@Override
	public Person savePerson(Person person) {
		tx.begin();
		em.persist(person);
		tx.commit();
		return person;
	}

	@Override
	public Person getPersonById(int pid) {
		Person person=em.find(Person.class, pid);
		if(person!=null) {
			tx.begin();
			tx.commit();
			return person;
		}
		return null;
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> persons=em.createQuery("from person", Person.class).getResultList();
		if (persons != null) {
			tx.begin();
			tx.commit();
			return persons;
		}
		return null;
	}

	@Override
	public boolean deletePersonById(int pid) {
		Person person=em.find(Person.class, pid);
		if(person!=null) {
			tx.begin();
			em.remove(person);
			tx.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Person> getPersonByGender(String gender) {
		List<Person> persons=em.createQuery("form person p where gener=?1",Person.class).setParameter(1, gender).getResultList();
		if (persons != null) {
			tx.begin();
			tx.commit();
			return persons;
		}
		return null;
	}

	@Override
	public List<Person> getPersonByAge(int age) {
		List<Person> persons=em.createQuery("form person p where age=?1",Person.class).setParameter(1, age).getResultList();
		if (persons != null) {
			tx.begin();
			tx.commit();
			return persons;
		}
		return null;
	}

	@Override
	public Person getPersonByPhone(long phno) {
		Person person=em.find(Person.class, phno);
		if (person != null) {
			tx.begin();
			tx.commit();
			return person;
		}
		return null;
	}
	
}
