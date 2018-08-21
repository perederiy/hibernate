package org.itstep;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentDAOTest {

	Student student;
	
	@Before
	public void setUp() throws Exception {
		student = new Student("Alex111", "qwerty", "Alex", "Pup", 23);
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.saveStudent(student);
		
	}

	@Test
	public void testSaveStudent() {
		StudentDAO studentDAO = new StudentDAO();
		Student result = studentDAO.getStudent("Alex111");
		assertNotNull(result);
		assertEquals("Alex111", result.getLogin());
		assertEquals("qwerty", result.getPassword());
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pup", result.getSecondName());
		assertEquals(Integer.valueOf(23), result.getAge());
	}
	@Test
	public void testUpdateStudent() {
		Student student1 = new Student("Alex111", "1111", "Vasia", "Dudkin", 12);
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.updateStudent(student1);
		Student result = studentDAO.getStudent("Alex111");
		assertEquals("1111", result.getPassword());
		assertEquals("Vasia", result.getFirstName());
		assertEquals("Dudkin", result.getSecondName());
		assertEquals(Integer.valueOf(12), result.getAge());
	}
	
	@Test
	public void testGetStudent() {
		StudentDAO studentDAO = new StudentDAO();
		Student result = studentDAO.getStudent("Alex111");
		assertNotNull(result);
		assertEquals("Alex111", result.getLogin());
		assertEquals("qwerty", result.getPassword());
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pup", result.getSecondName());
		assertEquals(Integer.valueOf(23), result.getAge());
	}
	
	@Test
	public void testDeleteStudent() {
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.deleteStudent(student);
		Student result = studentDAO.getStudent("Alex111");
		assertNull(result);
	}
	
	@Test
	public void testGetStudentByLoginAndPassword() {
		StudentDAO studentDAO = new StudentDAO();
		Student result = studentDAO.getStudentByLoginAndPassword(student.getLogin(), student.getPassword());
		assertEquals("Alex111", result.getLogin());
		assertEquals("qwerty", result.getPassword());
	}
	@Test
	public void testGetStudentByFirstName() {
		StudentDAO studentDAO = new StudentDAO();
		List<Student> result = studentDAO.getStudentToFirstName(student.getFirstName());
		for (Student studentArray : result) {
			assertEquals("Alex", studentArray.getFirstName());
		}
	}

	@After
	public void tearDown() throws Exception {
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.deleteStudent(student);
		
	}
}
