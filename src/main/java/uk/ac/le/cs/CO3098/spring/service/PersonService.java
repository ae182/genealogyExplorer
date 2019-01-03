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
	
}
