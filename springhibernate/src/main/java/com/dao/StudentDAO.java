package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDAO {

	public List<Student> list();

	public void save(Student student);

}
