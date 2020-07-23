package com.sj.model;

import java.util.List;

import com.sj.bean.Student;

public interface StudentDAO {

	public List<Student> getStudentList();

	public void storeStudent(Student student);
}
