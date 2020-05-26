package com.srimant.service;

import java.util.List;

import com.srimant.model.Teacher;

public interface TeacherService {

public Teacher getTeacherById(int teacherId);
	
	public List<Teacher> getAllTeacher();
	
	public void saveOrUpdateTeacher(Teacher teacher);
	
	public void deleteTeacher(Teacher teacher);
}
