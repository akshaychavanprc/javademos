package com.emp;
import javax.persistence.*;

@Entity
@Table(name="TBL_EMPLOYEES")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="fist_name")
	private String fistName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email",nullable=false,length=200)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//getter & setter
	
	
}
