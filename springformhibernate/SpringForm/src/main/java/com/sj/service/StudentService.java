package com.sj.service;

import java.util.List;

import com.sj.bean.Student;

public interface StudentService {

	public List<Student> getStudentList();

	public void storeStudent(Student student);

}
