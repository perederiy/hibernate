package org.itstep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name ="login", length=50, nullable=false)
	private String login;
	@Column(name="password", length=50, nullable=false)
	private String password;
	@Column(name="first_name", length=50)
	private String firstName;
	@Column(name="second_name", length=50)
	private String secondName;
	@Column(name="age")
	private Integer age;
	
	public Student(String login, String password, String firstName, String secondName, Integer age) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}

	public Student() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
