package net.javaguidesspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.boot.autoconfigure.domain.EntityScan;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//@EntityScan
@Entity
@Table(name = "users")

public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
	@Column(name = "firstname")
private String firstname;
	@Column(name = "lastname")
private String lastname;
	@Column(name = "email")
private String email;

	public Users() {
		
	}

public Users(String firstname, String lastname, String email) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
