package org.itstep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
}
