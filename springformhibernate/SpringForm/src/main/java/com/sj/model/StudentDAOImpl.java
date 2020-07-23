package com.sj.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sj.bean.Student;

/**
 * 
 * @author jangachary
 *
 */

@Repository
public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public List<Student> getStudentList() {

		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

	public void storeStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(student);

	}

}
