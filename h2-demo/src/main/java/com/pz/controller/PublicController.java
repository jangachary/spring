package com.pz.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pz.beans.Student;
import com.pz.services.StudentService;

/**
 *
 * @author jangachary
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PublicController {

	Gson gson = new Gson();
	@Autowired
	private StudentService studentService;
	private static final Logger LOGGER = LogManager.getLogger(PublicController.class);

	@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String hello() {
		JsonObject jo = new JsonObject();
		try {
			jo.addProperty("DATE", new Date().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson.toJson(jo);
	}

	@PostMapping(value = "/fetchStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchPosts() {
		String res = "";
		try {
			LOGGER.info("Start of fetchStudents");
			List<Student> students = studentService.getStudents();
			res = gson.toJson(students);
		} catch (Exception e) {
			res = "failed";
		}
		LOGGER.info("End fetchStudents");
		return res;
	}

	@PostMapping(value = "/saveStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchPosts(@RequestBody String data) {
		String res = "";
		try {
			LOGGER.info("Start of saveStudent");
			Student student = gson.fromJson(data, Student.class);
			res = studentService.save(student);
		} catch (Exception e) {
			res = "failed";
		}
		LOGGER.info("End saveStudent");
		return res;
	}

}