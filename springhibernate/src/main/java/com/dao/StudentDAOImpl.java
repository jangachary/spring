package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Student;

public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> list() {

		Session session = this.sessionFactory.openSession();
		List<Student> personList = session.createQuery("from Student").list();
		session.close();

		return personList;
	}

	@Override
	public void save(Student student) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();

	}
}
