package uk.ac.le.cs.CO3098.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.le.cs.CO3098.spring.domain.APerson;
import uk.ac.le.cs.CO3098.spring.domain.Person;
import uk.ac.le.cs.CO3098.spring.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired 
	private PersonRepository personRepository;
	
	public void savePerson(APerson p) {
		personRepository.save(p);
		
	}
	
	public int[] getParent(String specialKey) {
		
		// This will get the direct parents
		int []parentIds = personRepository.getParent(specialKey);
		
		for (int i = 0; i < parentIds.length; i++) {
			
			
		}
		
	}
	
	public APerson getPerson(String specialKey) {
		return personRepository.findAPersonBySpecialKey(specialKey);
	}
	
	public void deleteAPerson(Integer id) {
			
		personRepository.delete(id);
		
	}
	
}
