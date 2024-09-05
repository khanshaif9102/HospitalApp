package com.shaif.hospital.dao;

import com.shaif.hospital.dto.Hospital;

public interface HospitalDao {
	public Hospital saveHospital(Hospital hospital);
	public Hospital getHospital(int id);
	public Hospital updateHospital(int hid,Hospital hospital);
	public boolean deleteHospital(int id);
}