package uk.ac.le.cs.CO3098.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.le.cs.CO3098.spring.domain.APerson;
import uk.ac.le.cs.CO3098.spring.domain.Person;
import uk.ac.le.cs.CO3098.spring.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired 
	private PersonRepository personRepository;
	
	public Iterable<APerson> findAllPersons() {
		return personRepository.findAll();
	}
	
	public void savePerson(APerson p) {
		personRepository.save(p);
		
	}
	// special key is 7
	public APerson getParent(String specialKey) {
		
		// This will get the direct parents of person 7
		// 0 f 
		// 1 m
		List<String> parentIds = personRepository.getParent(specialKey);
		
		System.out.println();
		
		//return getParent(parentIds[0]);
		return new APerson();
		
	}
	
	public APerson getParentTwo(String specialKey) {
		
		APerson currentPerson = new APerson();
		//APerson currentPerson = personRepository.find(Integer.parseInt(specialKey));		
		
		System.out.println(currentPerson);
		
		if (currentPerson.getMothersKey() != null || currentPerson.getFathersKey() != null) {
			
			getParentTwo(currentPerson.getMothersKey());
			
			getParentTwo(currentPerson.getFathersKey());
			
		} 
		
		return currentPerson; 
		
	}
	
	
	public APerson getPerson(String specialKey) {
		return personRepository.findAPersonBySpecialKey(specialKey);
	}
	
	public void deleteAPerson(Integer id) {
			
		personRepository.delete(id);
		
	}
	
}
