package com.srimant.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srimant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Student getStudent(int rollNo) {
		
		return getSession().get(Student.class, rollNo);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(Student.class);
		return (List<Student>) criteria.list();
	}

	public void saveOrUpdateStudent(Student student) {
		
		getSession().saveOrUpdate(student);
	}

	public void deleteStudent(int rollNo) {
		Student student = getSession().get(Student.class, rollNo);
		getSession().delete(student);
	}

}
