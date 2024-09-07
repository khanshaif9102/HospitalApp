package com.shaif.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shaif.hospital.dao.AddressDao;
import com.shaif.hospital.dto.Address;
import com.shaif.hospital.dto.Branch;

public class AddressDaoImp implements AddressDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shaif");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();

	@Override
	public Address saveAddress(Address address, int bid) {
		tx.begin();
		Branch branch=em.find(Branch.class, bid);
		if(branch!=null) {
		em.persist(address);
		tx.commit();
		return address;
		}
		return null;
	}

	@Override
	public Address getAddressById(int aid) {
		Address address=em.find(Address.class, aid);
		if (address != null) {
			tx.begin();
			tx.commit();
			return address;
		}
		return null;
	}

	@Override
	public Address updateAddressById(int aid, Address address) {
		Address address1=em.find(Address.class, aid);
		if (address1 != null) {
			tx.begin();
			address1.setCountry(address.getCountry());
			address1.setState(address.getState());
			address1.setStreet(address.getStreet());
			address1.setPin(address.getPin());
			tx.commit();
			return address1;
		}
		return null;
	}

	@Override
	public boolean deleteAddressById(int aid) {
		Address address=em.find(Address.class, aid);
		if (address != null) {
			tx.begin();
			em.remove(address);
			tx.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Address> getAllAddresses() {
		List<Address> addresses=em.createQuery("from Address", Address.class).getResultList();
		if (addresses != null) {
            tx.begin();
            tx.commit();
            return addresses;
		}
		return null;
	}
	
}
