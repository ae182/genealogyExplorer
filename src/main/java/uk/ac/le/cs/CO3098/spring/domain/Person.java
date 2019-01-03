package uk.ac.le.cs.CO3098.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Person")
public class Person implements Serializable {
	

	// Equivalent to id
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "key")
	private String specialKey;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mothersKey")
	private String mothersKey;
	
	@Column(name = "fathersKey")
	private String fathersKey;
	
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	
	@Column(name = "gender")
	private String gender;
		
	public Integer getId() {
		return Id;
	}
		
	public void setId(Integer Id) {
		this.Id = Id;
	}
	
	public String getSpecialKey() {
		return specialKey;
	}
	
	public void setSpecialKey(String specialKey) {
		this.specialKey = specialKey;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMothersKey() {
		return mothersKey;
	}

	public void setMothersKey(String mothersKey) {
		this.mothersKey = mothersKey;
	}

	public String getFathersKey() {
		return fathersKey;
	}

	public void setFathersKey(String fathersKey) {
		this.fathersKey = fathersKey;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

