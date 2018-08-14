package org.itstep;

public class AppRunner {

	public static void main(String[] args) {
		Student student = new Student("alex333", "qwerty","Alex", "Pupkin", 23);
		StudentDAO dao = new StudentDAO();
		dao.saveStudent(student);
	}

}
