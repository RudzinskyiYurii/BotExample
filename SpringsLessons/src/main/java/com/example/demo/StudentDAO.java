package com.example.demo;

public interface StudentDAO {

	public void insert(Student student);
	public Student findByLastName(String lastName);
	
}
