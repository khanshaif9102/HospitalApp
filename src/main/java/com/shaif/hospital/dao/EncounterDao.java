package com.shaif.hospital.dao;

import java.util.List;

import com.shaif.hospital.dto.Encounter;

public interface EncounterDao {
	public Encounter saveEncounter(Encounter encounter, int bid);

	public Encounter getEncounterById(int eid);

	public List<Encounter> getAllEncounters();

	public Encounter updateEncounterById(int eid, Encounter encounter);

	public boolean deleteEncounterById(int eid);

}
