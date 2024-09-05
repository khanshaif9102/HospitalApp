package com.shaif.hospital.dao;

import java.util.List;

import com.shaif.hospital.dto.MedOrder;

public interface MedOrderDao {
	public MedOrder saveMedOrder(MedOrder medOrder, int eid);

	public MedOrder getMedOrderById(int mid);

	public List<MedOrder> getAllMedOrders();

	public boolean deleteMedOrderById(int mid);

	public List<MedOrder> getMedOrdersByDoctorName(int eid);

	public List<MedOrder> getMedOrderByDate(String date);

	public MedOrder updateMedOrderById(int mid, MedOrder medOrder);
}
