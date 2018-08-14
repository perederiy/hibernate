package org.itstep;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class StudentDAO {

	private Session session;

	public void saveStudent(Student student) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	public void updateStudent(Student student) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.update(student);
		session.getTransaction().commit();
		session.close();
	}

	public Student getStudent(String login) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Student student = session.get(Student.class, login);
		session.getTransaction().commit();
		session.close();
		return student;
	}

	public void deleteStudent(Student student) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}

	public Student getStudentByLoginAndPassword(String login, String password) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createNativeQuery("SELECT * FROM student WHERE login=:login AND password=:password", Student.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		Student student = (Student) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return student;
	}
	
	public List<Student> getStudentToFirstName(String firstName) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createNativeQuery("SELECT * FROM student WHERE first_name=:first_name", Student.class);
		query.setParameter("first_name", firstName);
		List<Student> students = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return students;
	}

	public List<Student> getStudentToSecondName(String secondName) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createNativeQuery("SELECT * FROM student WHERE second_name=:second_name", Student.class);
		query.setParameter("second_name", secondName);
		List<Student> students = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return students;
	}

	public List<Student> getStudentToAge(Integer age) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createNativeQuery("SELECT * FROM student WHERE age=:age", Student.class);
		query.setParameter("age", age);
		List<Student> students = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return students;
	}
	
}
