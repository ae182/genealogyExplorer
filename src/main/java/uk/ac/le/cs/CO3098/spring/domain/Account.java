package uk.ac.le.cs.CO3098.spring.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Account {
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMotherId() {
		return motherId;
	}
	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    

	/*
	public Account(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public Account() {
		super();
	}

*/
    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;
    
    @Column(name = "name")
	String name;
    
    @Column(name = "motherId")
	String motherId;

    @Column(name = "fatherId")
	String fatherId;
    
    @Column(name = "gender")
	String gender;
    
    @Column(name = "dateOfBirth")
	String dateOfBirth;


}
