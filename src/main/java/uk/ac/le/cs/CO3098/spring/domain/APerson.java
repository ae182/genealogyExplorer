package uk.ac.le.cs.CO3098.spring.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "APerson")
public class APerson {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "specialKey")
	private String specialKey;
	
	@Column(name = "mothersKey")
	private String mothersKey;
	
	@Column(name = "fathersKey")
	private String fathersKey;
	
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	
	@Column(name = "gender")
	private String gender;
	
	@Transient
	private List<APerson> Ancestors;
	
	@Transient
	private int m,f; 
	
//	public APerson(String specialKey, String name, String dateOfBirth, String mothersKey, String fathersKey, String gender) {
//		this.specialKey = specialKey;
//		this.name = name;
//		this.dateOfBirth = dateOfBirth;
//		this.mothersKey = mothersKey;
//		this.fathersKey = fathersKey;
//		this.gender = gender;
//		
//	}
	
	public APerson(String specialKey, String name, String dateOfBirth, String mothersKey, String fathersKey, String gender) {
		this.specialKey = specialKey;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.mothersKey = mothersKey;
		this.fathersKey = fathersKey;
		this.gender = gender;
		
	}
	
	public APerson() {
		Ancestors = new ArrayList<APerson>();
	}
	
	public void setAncestors(APerson person) {
		
		Ancestors.add(person);
	}
	
	public List<APerson> getAncestors() {
		return Ancestors;
	}
	
		
	@Override
	public String toString() {
		       return "Name: '" + this.name 
				+ "', specialKey: '" + this.specialKey
				+ "', mothersKey: '" + this.mothersKey 
				+ "', fathersKey: '" + this.fathersKey
				+ "', DOB: '" + this.dateOfBirth
				+ "', gender: '" + this.gender 
				+ "', mothersKey: '" + this.mothersKey + "'";
	} 
	
	public Integer getId() {
		return Id;
	}
		
	public void setId(Integer Id) {
		this.Id = Id;
	}
	
	public String getSpecialKey() {
		return this.specialKey;
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
	
	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
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
