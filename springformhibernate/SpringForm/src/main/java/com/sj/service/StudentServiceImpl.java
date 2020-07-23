package com.sj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sj.bean.Student;
import com.sj.model.StudentDAO;
/**
 * 
 * @author jangachary
 *
 */

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {

		this.studentDAO = studentDAO;
	}

	@Transactional
	public List<Student> getStudentList() {

		return studentDAO.getStudentList();
	}

	@Transactional
	public void storeStudent(Student student) {

		this.studentDAO.storeStudent(student);

	}

}
