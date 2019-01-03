package uk.ac.le.cs.CO3098.spring.domain;

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
