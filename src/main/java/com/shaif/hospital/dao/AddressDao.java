package com.shaif.hospital.dao;

import java.util.List;

import com.shaif.hospital.dto.Address;

public interface AddressDao {
	public Address saveAddress(Address address, int bid);

	public Address getAddressById(int aid);

	public Address updateAddressById(int aid, Address address);

	public boolean deleteAddressById(int aid);
	
	public List<Address> getAllAddresses();
	
}
