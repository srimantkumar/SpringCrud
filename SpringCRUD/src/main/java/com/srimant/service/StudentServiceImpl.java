package com.srimant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srimant.dao.StudentDao;
import com.srimant.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	StudentDao customerDao;
	
	@Autowired
	public void setCustomerDao(StudentDao customerDao) {
		this.customerDao = customerDao;
	}

	public Student getStudent(int rollNo) {
		
		return customerDao.getStudent(rollNo);
	}

	public List<Student> getAllStudent() {
		
		return customerDao.getAllStudent();
	}

	public void saveOrUpdateStudent(Student student) {
		
		customerDao.saveOrUpdateStudent(student);
	}

	public void deleteStudent(int rollNo) {
		
		customerDao.deleteStudent(rollNo);
	}

}
