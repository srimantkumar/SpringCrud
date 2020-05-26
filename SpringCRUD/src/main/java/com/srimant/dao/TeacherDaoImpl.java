package com.srimant.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srimant.model.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public Teacher getTeacherById(int teacherId) {
		Teacher teacher = getSession().get(Teacher.class, teacherId);;
		return teacher;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeacher() {
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(Teacher.class);
		return (List<Teacher>) criteria.list();
	}

	public void saveOrUpdateTeacher(Teacher teacher) {
		getSession().saveOrUpdate(teacher);
	}

	public void deleteTeacher(Teacher teacher) {
		getSession().delete(teacher);

	}

}
