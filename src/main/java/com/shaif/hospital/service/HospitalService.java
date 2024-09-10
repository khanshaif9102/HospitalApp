package com.shaif.hospital.service;

import java.util.List;

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
	
	public Hospital getHospital(int id) {
		HospitalDaoImp dao = new HospitalDaoImp();
        Hospital h = dao.getHospital(id);
        if(h!=null) {
            System.out.println("Hospital is found");
            return h;
        }
        else {
            System.out.println("Hospital is not found");
            return null;
        }
    }
	
	public Hospital updateHospital(int hid, Hospital hospital) {
		HospitalDaoImp dao = new HospitalDaoImp();
        Hospital h = dao.updateHospital(hid, hospital);
        if(h!=null) {
            System.out.println("Hospital is updated");
            return h;
        }
        else {
            System.out.println("Hospital is not updated");
            return null;
        }
	}
	
	public boolean deleteHospital(int id) {
		HospitalDaoImp dao = new HospitalDaoImp();
		boolean h = dao.deleteHospital(id);
		if (h) {
			System.out.println("Hospital is deleted");
			return true;
		} else {
			System.out.println("Hospital is not deleted");
			return false;
		}
	}
	
	public List<Hospital> getAllHospitals() {
		HospitalDaoImp dao = new HospitalDaoImp();
        List<Hospital> hospitals = dao.getAllHospitals();
        if (hospitals != null) {
            System.out.println("Hospitals are found");
            return hospitals;
        } else {
            System.out.println("Hospitals are not found");
            return null;
	}
	}

}
