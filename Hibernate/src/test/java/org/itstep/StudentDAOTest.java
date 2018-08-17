package org.itstep;

import static org.junit.Assert.*;

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
	public void test() {
		StudentDAO studentDAO = new StudentDAO();
		Student result = studentDAO.getStudent("Alex111");
		assertNotNull(result);
		assertEquals("Alex111", result.getLogin());
		assertEquals("qwerty", result.getPassword());
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pup", result.getSecondName());
		assertEquals(Integer.valueOf(23), result.getAge());
	}

	@After
	public void tearDown() throws Exception {
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.deleteStudent(student);
		
	}
}
