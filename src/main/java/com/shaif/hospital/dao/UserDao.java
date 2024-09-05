package com.shaif.hospital.dao;

import java.util.List;

import com.shaif.hospital.dto.User;

public interface UserDao {
	public User saveUser(User user);

	public User getUserById(int uid);

	public List<User> getAllUsers();

	public User getUserByUserName(String userName);

	public User getUserByRole(String role);

	public boolean deleteUserById(int uid);
}
