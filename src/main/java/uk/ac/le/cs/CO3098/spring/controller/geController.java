package uk.ac.le.cs.CO3098.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.le.cs.CO3098.spring.domain.Person;
import uk.ac.le.cs.CO3098.spring.service.PersonService;

@Controller
@RequestMapping("/GE/person")
public class geController {
	
	@Autowired
	public PersonService personService; 
	
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
		
		
		Person person = new Person();
		
		/*
		System.out.println("The key is ... ");
		System.out.println(key);
		System.out.println("The name is ... ");
		System.out.println(name);
		*/
		
		person.setId(Integer.parseInt(key));
		person.setName(name);
		person.setDateOfBirth(dob);
		person.setMothersKey(m);
		person.setFathersKey(f);
		person.setGender(g);
		
			
		personService.savePerson(person);
		
		return "Person inserted into database";
		
	}

}
