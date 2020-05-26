package com.srimant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srimant.dao.TeacherDao;
import com.srimant.model.Teacher;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	
	public Teacher getTeacherById(int teacherId) {
		
		return teacherDao.getTeacherById(teacherId);
	}

	public List<Teacher> getAllTeacher() {
		
		return teacherDao.getAllTeacher();
	}

	public void saveOrUpdateTeacher(Teacher teacher) {
		
		teacherDao.saveOrUpdateTeacher(teacher);
	}

	public void deleteTeacher(Teacher teacher) {
		
		teacherDao.deleteTeacher(teacher);
	}

}
