package com.srimant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.srimant.model.Student;
import com.srimant.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("/student/form");
		Student student = new Student();
		modelAndView.addObject("studentDetails", student);
		return modelAndView;		
	}
	
	@RequestMapping(value="/getAllStudent", method=RequestMethod.GET)
	public ModelAndView getAllStudents() {
		ModelAndView modelAndView = new ModelAndView("/student/list");
		List<Student> studentList = studentService.getAllStudent();
		modelAndView.addObject("studentList", studentList);
		return modelAndView;
	}
	
	@RequestMapping(value="/update/{rollNo}", method=RequestMethod.GET)
	public ModelAndView updateStudent(@PathVariable("rollNo") int rollNo) {
		ModelAndView modelAndView = new ModelAndView("/student/form");
		Student student = studentService.getStudent(rollNo);
		modelAndView.addObject("studentDetails", student);
		return  modelAndView;		
	}
	
	@RequestMapping(value="/delete/{rollNo}", method=RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable("rollNo") int rollNo) {
		studentService.deleteStudent(rollNo);
		return new ModelAndView("redirect:/student/getAllStudent");
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute("studentDetails") Student student) {
		studentService.saveOrUpdateStudent(student);
		return new ModelAndView("redirect:/student/getAllStudent");
	}
}
