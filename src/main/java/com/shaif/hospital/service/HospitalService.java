package com.shaif.hospital.service;

import com.shaif.hospital.dao.imp.HospitalDaoImp;
import com.shaif.hospital.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
        HospitalDaoImp dao = new HospitalDaoImp();
        Hospital h = dao.saveHospital(hospital);
        if(h!=null) {
        	System.out.println("Hospital is saved successfully");
        }
        else {
        	System.out.println("Hospital is not saved");
        }	
	}

}
