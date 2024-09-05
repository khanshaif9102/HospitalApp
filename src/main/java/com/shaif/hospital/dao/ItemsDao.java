package com.shaif.hospital.dao;

import java.util.List;

import com.shaif.hospital.dto.Item;

public interface ItemsDao {
	public Item saveItem(int mid, Item item);

	public Item getItemById(int mid);

	public List<Item> getAllItems();

	public boolean deleteItemById(int aid);

}
