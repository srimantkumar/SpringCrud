package com.srimant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.srimant.model.Teacher;
import com.srimant.service.TeacherService;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@GetMapping(value="/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("/teacher/teacherForm");
		Teacher teacher = new Teacher();
		modelAndView.addObject("teacherDetails", teacher);
		return modelAndView;
	}
	
	@PostMapping(value="/insert")
	public ModelAndView insertTeacher(@ModelAttribute("teacherDetails") Teacher teacher) {
		teacherService.saveOrUpdateTeacher(teacher);
		return new ModelAndView("redirect:/teacher/getAllTeacher");
	}
	
	@GetMapping(value="/getAllTeacher")
	public ModelAndView getAllTeacher() {
		ModelAndView modelAndView = new ModelAndView("/teacher/teacherList");
		List<Teacher> teachers = teacherService.getAllTeacher();
		modelAndView.addObject("teacherList", teachers);
		return modelAndView;
	}
	
	@GetMapping(value="/update/{id}")
	public ModelAndView updateTeacher(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("/teacher/teacherForm");
		Teacher teacher = teacherService.getTeacherById(id);
		modelAndView.addObject("teacherDetails", teacher);
		return modelAndView;
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView deleteTeacher(@PathVariable("id") int id) {
		Teacher teacher = teacherService.getTeacherById(id);
		teacherService.deleteTeacher(teacher);
		return new ModelAndView("redirect:/teacher/getAllTeacher");
	}
	
}
