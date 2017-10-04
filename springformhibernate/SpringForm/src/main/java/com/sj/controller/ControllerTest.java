package com.sj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sj.bean.Student;
import com.sj.service.StudentService;

/**
 * 
 * @author jangachary
 *
 */

@Controller
@EnableTransactionManagement
public class ControllerTest {
	@Autowired
	private Student student;

	@Autowired
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {

		this.studentService = studentService;
	}

	@RequestMapping("/test")
	public String test(Model model) {

		model.addAttribute("msg", "testing");
		return "hello";
	}

	@RequestMapping(value = "/all")
	public String getAll(Model model) {

		model.addAttribute("list", studentService.getStudentList());

		return "all";
	}

	@RequestMapping(value = "/store")
	public String register(Model model) {

		model.addAttribute("student", student);

		return "register";
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public String store(@ModelAttribute("student") Student student, Model model) {
		this.studentService.storeStudent(student);
		return "result";
	}
}
