package com.shaif.hospital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shaif.hospital.dao.imp.AddressDaoImp;
import com.shaif.hospital.dao.imp.BranchDaoImp;
import com.shaif.hospital.dto.Address;
import com.shaif.hospital.dto.Branch;
import com.shaif.hospital.dto.Encounter;
import com.shaif.hospital.dto.Hospital;
import com.shaif.hospital.service.EncounterService;
import com.shaif.hospital.service.HospitalService;

public class HospitalAppController {
	public static void main(String[] args) {
		Hospital hospital=new Hospital();
		HospitalService hs=new HospitalService();
		Branch branch=new Branch();
		BranchDaoImp bd=new BranchDaoImp();
		Address address=new Address();
		AddressDaoImp ad=new AddressDaoImp();
		EncounterService es=new EncounterService();
		
		System.out.println("Hospital App Controller");
		Scanner sc=new Scanner(System.in);
		int choice;
		while(true) {
		System.out.println("Enter your choice");
		System.out.println("=========================");
		System.out.println("1. Hospital");
		System.out.println("2. Branch");
		System.out.println("3. Address");
		System.out.println("4. Encounter");
		System.out.println("5. MedOrder");
		System.out.println("6. Items");
		System.out.println("7. Observations");
		System.out.println("8. Person");
		System.out.println("9. User");
		System.out.println("10. Exit");
		System.out.println("=========================");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Hospital");
			int choice1;
			System.out.println("Enter your choice");
			System.out.println("=========================");
			System.out.println("1. Save Hospital");
			System.out.println("2. Get Hospital");
			System.out.println("3. Update Hospital");
			System.out.println("4. Delete Hospital");
			System.out.println("5. Exit");
			choice1=sc.nextInt();
			switch(choice1) {
			case 1:
				System.out.println("Save Hospital");
				System.out.println("Enter Hospital Name");
				hospital.setName(sc.next());
				System.out.println("Enter Hospital Website");
				hospital.setWebsite(sc.next());
				hs.saveHospital(hospital);
				break;
				
			case 2:
				System.out.println("Get Hospital");
				System.out.println("Enter Hospital Id");
				hospital=hs.getHospital(sc.nextInt());
				System.out.println("Hospital Id: "+hospital.getHid());
				System.out.println("Hospital Name: "+hospital.getName());
				System.out.println("Hospital Website: "+hospital.getWebsite());
				System.out.println("Hospital :"+hospital.getBranches());
				break;
				
			case 3:
				System.out.println("Update Hospital");
				System.out.println("Enter Hospital Id");
				int id=sc.nextInt();
				System.out.println("Enter Hospital Name");
				hospital.setName(sc.next());
				System.out.println("Enter Hospital Website");
				hospital.setWebsite(sc.next());
				hospital =hs.updateHospital(id, hospital);
				System.out.println("Hospital Id: "+hospital.getHid());
				System.out.println("Hospital Name: "+hospital.getName());
				System.out.println("Hospital Website: "+hospital.getWebsite());
				System.out.println("Hospital :"+hospital.getBranches());
				break;
				
			case 4:
				System.out.println("Delete Hospital");
				System.out.println("Enter Hospital Id");
				hs.deleteHospital(sc.nextInt());
				break;
			case 5:
				System.out.println("Exit");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			break;
		case 2:
			System.out.println("Branch");
			int choice2;
			System.out.println("Enter your choice");
			System.out.println("=========================");
			System.out.println("1. Save Branch");
			System.out.println("2. Get Branch");
			System.out.println("3. Update Branch");
			System.out.println("4. Delete Branch");
			System.out.println("5. Exit");
			choice2=sc.nextInt();
			switch(choice2) {
			case 1:
				System.out.println("Save Branch");
				System.out.println("Enter Hospital Id");
				int hid = sc.nextInt();
				System.out.println("Enter Branch Name");
				branch.setName(sc.next());
				System.out.println("enter branch email");
				branch.setEmail(sc.next());
				System.out.println("enter branch phone");
				branch.setPhno(sc.nextLong());
				List<Address> addresses=ad.getAllAddresses();
				System.out.println("enter address id from below list");
				for (Address a : addresses) {
					System.out.println(a);
				}
				branch.setAddresses(ad.getAddressById(sc.nextInt()));
				
				System.out.println("enter hospital id from below list");
				List<Hospital> hospitals=hs.getAllHospitals();
				for (Hospital h : hospitals) {
					System.out.println(h);
				}
				branch.setHospitals(hs.getHospital(sc.nextInt()));
				List<Encounter> encounters=es.getAllEncounters();
				System.out.println("enter encounter id from below list");
				for (Encounter e : encounters) {
					System.out.println(e);
				}
				List<Encounter> list=new ArrayList<Encounter>();
				list.add(es.getEncounterById(sc.nextInt()));
				branch.setEncounters(list);
				branch=bd.saveBranch(hid, branch);
				break;
			}
			break;
			
		case 10:
			System.out.println("Exit");
			System.exit(0);
			break;
		default:
            System.out.println("Invalid Choice");
            break;
		}
		}
		
		
	}

}
