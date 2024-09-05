package com.shaif.hospital.dao;

import java.util.List;

import com.shaif.hospital.dto.Person;

public interface PersonDao {
	public Person savePerson(Person person);

	public Person getPersonById(int pid);

	public List<Person> getAllPersons();

	public boolean deletePersonById(int pid);

	public List<Person> getPersonByGender(String gender);

	public List<Person> getPersonByAge(int age);

	public Person getPersonByPhone(long phno);
}
