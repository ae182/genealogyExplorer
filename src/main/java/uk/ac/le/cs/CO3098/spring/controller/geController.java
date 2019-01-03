package uk.ac.le.cs.CO3098.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.le.cs.CO3098.spring.domain.APerson;
import uk.ac.le.cs.CO3098.spring.domain.Person;
import uk.ac.le.cs.CO3098.spring.service.PersonService;

@Controller
@RequestMapping("/GE/person")
public class geController {
	
	@Autowired
	public PersonService personService; 
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable String id) {
		
		System.out.println("Id to be deleted is " + id);
		
		APerson personToDelete = personService.getPerson(id);
		
		personService.deleteAPerson(personToDelete.getId());
		
		return "Id to be deleted is " + id;
	}
	
	// GET /GE/person/get/12
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public @ResponseBody String get(@PathVariable String id) {
				
		APerson personInfo = personService.getPerson(id);
		
		if (personInfo == null ) {
			
			return "Person does not exist";
			
		} else {
			
			return personInfo.toString();
		}
				
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public @ResponseBody String add(
			@RequestParam(value="key") String key,
			@RequestParam(value="name") String name,
			@RequestParam(value="dob") String dob,
			@RequestParam(value="m") String m,
			@RequestParam(value="f") String f,
			@RequestParam(value="g") String g
			)
	 {
		
		// Exception checking to make properties are not empty
		if (
			key.isEmpty() || key == null || 
			name.isEmpty() || name == null ||
			dob.isEmpty() || dob == null ||
			m.isEmpty() || m == null ||
			f.isEmpty() || m == null ||
			g.isEmpty() || g == null
			) {
			

			return " GeneralException: Cannot create a Person since some of the fields are empty ";
		}
		
		APerson person = new APerson();
	
		person.setSpecialKey(key);
		person.setName(name);
		person.setDateOfBirth(dob);
		person.setMothersKey(m);
		person.setFathersKey(f);
		person.setGender(g);
		
		// Check whether the mother and father property has been set otherwise insert into database
		if (person.getMothersKey() == "" && person.getFathersKey() == "" ) {
			
			personService.savePerson(person);
		}
			
		// Check that the person already exists
		APerson isPersonExist = personService.getPerson(person.getSpecialKey());
				
		if (isPersonExist == null) {
			
			// The database is completely empty, create person
			personService.savePerson(person);
			return "Database was empty we are going to create a person";
					
		} else {
			
			APerson mother = personService.getPerson(isPersonExist.getMothersKey());
			APerson father = personService.getPerson(isPersonExist.getFathersKey());
			
			if (mother != null && father != null ) {
				
				personService.savePerson(person);
				return "person save into database";
				
			} else {
				// no parents don't create person 
				
				//System.out.println("No parents don't create person");
				//return "No parents don't create person";
				
				personService.savePerson(person);
				return  "person saved";
			}
						
			
		}
				
	} // End method
	
	

}
