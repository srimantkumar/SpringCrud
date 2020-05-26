package com.srimant.dao;

import java.util.List;

import com.srimant.model.Teacher;

public interface TeacherDao {
	
	public Teacher getTeacherById(int teacherId);
	
	public List<Teacher> getAllTeacher();
	
	public void saveOrUpdateTeacher(Teacher teacher);
	
	public void deleteTeacher(Teacher teacher);

}
