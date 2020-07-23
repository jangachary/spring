package com.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDAO;
import com.model.Student;

public class Test {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// O personDAO = context.getBean(PersonDAO.class);
		StudentDAO dao = context.getBean(StudentDAO.class);

		/// Person person = new
		/// Person();person.setName("Pankaj");person.setCountry("India");

		Student student = new Student();

		student.setId(497);
		student.setMobile("9553536654");
		student.setName("janga");
		System.out.println(student);
		dao.save(student);

		System.out.println(student);

		List<Student> list = dao.list();

		for (Student p : list) {
			System.out.println("Person List::" + p);
		}

	}
}