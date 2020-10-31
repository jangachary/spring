package com.pz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pz.beans.Student;
import com.pz.dao.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public String save(Student student) {
		try {
			studentRepository.save(student);
		} catch (Exception e) {
			return "student ading failed";
		}

		return "student added ";
	}

	public List<Student> getStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

}