package com.shaif.hospital.service;

import java.util.List;

import com.shaif.hospital.dao.imp.EncounterDaoImp;
import com.shaif.hospital.dto.Encounter;

public class EncounterService {
	Encounter encounter=new Encounter();
	EncounterDaoImp encounterDaoImp = new EncounterDaoImp();
	public Encounter saveEncounter(Encounter encounter, int bid) {
		encounter = encounterDaoImp.saveEncounter(encounter, bid);
		if (encounter != null) {
			System.out.println("Encounter is saved successfully");
			return encounter;
		} else {
			System.out.println("Encounter is not saved");
			return null;
		}
	}
	
	public Encounter getEncounterById(int eid) {
		encounter = encounterDaoImp.getEncounterById(eid);
        if (encounter != null) {
            System.out.println("Encounter is found");
            return encounter;
        } else {
            System.out.println("Encounter is not found");
            return null;
        }
    }
	
	public List<Encounter> getAllEncounters() {
		List<Encounter> encounters = encounterDaoImp.getAllEncounters();
        if (encounters != null) {
            System.out.println("Encounters are found");
            return encounters;
        } else {
            System.out.println("Encounters are not found");
            return null;
        }
    }
	
	public Encounter updateEncounterById(int eid,Encounter encounter) {
		this.encounter=encounterDaoImp.updateEncounterById(eid, encounter);
		if (this.encounter != null) {
			System.out.println("Encounter is updated");
			return this.encounter;
		} else {
			System.out.println("Encounter is not updated");
			return null;
		}
	}
	
	public boolean deleteEncounterById(int eid) {
		boolean flag=encounterDaoImp.deleteEncounterById(eid);
		if (flag) {
			System.out.println("Encounter is deleted");
			return true;
		} else {
			System.out.println("Encounter is not deleted");
			return false;
		}
	}
	
	

}
