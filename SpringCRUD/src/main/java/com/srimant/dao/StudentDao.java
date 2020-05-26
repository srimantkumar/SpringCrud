package com.srimant.dao;

import java.util.List;

import com.srimant.model.Student;

public interface StudentDao {

public Student getStudent(int rollNo);
	
	public List<Student> getAllStudent();
	
	public void saveOrUpdateStudent(Student student);
	
	public void deleteStudent(int rollNo);
}
