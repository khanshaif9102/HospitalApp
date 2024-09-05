package com.shaif.hospital.dao;

import java.util.List;

import com.shaif.hospital.dto.Observation;

public interface ObservationDao {
	public Observation saveObservation(Observation observation, int eid);

	public Observation getObservationById(int oid);

	public List<Observation> getAllObservations();

	public boolean deleteObservationById(int oid);

	public List<Observation> getObservationByDoctorName(String name);

	public Observation updateObservationById(int oid, Observation observation);

}
