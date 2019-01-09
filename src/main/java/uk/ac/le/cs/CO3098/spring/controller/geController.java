package uk.ac.le.cs.CO3098.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.ac.le.cs.CO3098.spring.domain.APerson;
import uk.ac.le.cs.CO3098.spring.domain.Parents2;
import uk.ac.le.cs.CO3098.spring.service.PersonService;

@Controller
@RequestMapping("/GE/person")
public class geController {
	
	@Autowired
	public PersonService personService; 
	
	// This return the create person view 
	 @RequestMapping(value = "/create")
    public ModelAndView create(){	
    	  return new ModelAndView("create");    
    } 
	
	// GET /listAll
	@RequestMapping( value = {"/listAll" })
	public ModelAndView listAll() {
		return new ModelAndView("Person/listAll", "persons", personService.findAllPersons());
	}
	
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
	//////
	
	
	// GET /GE/person/ancestors/6
//	@RequestMapping(value="/ancestors/{id}", method=RequestMethod.GET)
//	public @ResponseBody String ancestors(@PathVariable String id) {
//		
//		System.out.println("It's working");
//		
//		// return that person object 
//		APerson person = personService.getPerson(id);
//				
//		person.setAncestors(personService.getParentTwo(id));
//		
//		System.out.println("It's working");
//		
//		//String [] mfids = personService.getParent(id);
//		
//			
//		return "something";
//		//return "Worked ";
//	}
	
	@RequestMapping(value = {"/ancestors/{id}"})
    public @ResponseBody Object ancestrors(@PathVariable Integer id){
	  List <Parents2> acc = new ArrayList<>();
	  int nid=id;
	  while(nid>0) {
		  if(personService.findById(nid)!=null)
		  acc.add(new Parents2(personService.findById(nid).getId()));
		  nid--;
	  }
	  int qwe= acc.size()-1;
	  while(qwe>=0) {
		  if(personService.findById(acc.get(qwe).getId())!=null) {
			  for(int ya=0;ya<acc.size();ya++) {
				  if(acc.get(ya).getId()== personService.findById(acc.get(qwe).getId()).getF()) {
		acc.get(qwe).addF(acc.get(ya));
				  }
			  }
		  }
		  if(personService.findById(acc.get(qwe).getId())!=null) {
			  for(int ya=0;ya<acc.size();ya++) {
				  if(acc.get(ya).getId()==personService.findById(acc.get(qwe).getId()).getM()) {
		  acc.get(qwe).addM(acc.get(ya));
		  }
			  }
		  }
		  qwe--;
	  }
	  Object asasa= acc.toString();
         return asasa;
    }
	
	//////
	
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public @ResponseBody String add(
			@RequestParam(value="key") String key,
			@RequestParam(value="name") String name,
			//@RequestParam(value="dob") String dob,
			@RequestParam(value="m", required = false) String m,
			@RequestParam(value="f", required = false) String f
			//@RequestParam(value="g") String g
			)
	 {
		
		APerson person = personService.getPerson(key);
		
		personService.setPersonsMotherAndFather(f, m,person.getSpecialKey());
		
		System.out.println( person.getName() );
		
		return person.getName();
		
		//return "inside method";
		/*
		// Exception checking to make properties are not empty
		if (
			key.isEmpty() || key == null || 
			name.isEmpty() || name == null ||
			//dob.isEmpty() || dob == null ||
			m.isEmpty() || m == null ||
			f.isEmpty() || m == null
			//g.isEmpty() || g == null
			) {
			

			return " GeneralException: Cannot create a Person since some of the fields are empty ";
		}
		
		APerson person = new APerson();
	
		person.setSpecialKey(key);
		person.setName(name);
		//person.setDateOfBirth(dob);
		person.setMothersKey(m);
		person.setFathersKey(f);
		//person.setGender(g);
		
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
						
			
		}*/
				
	} // End method
	
	
	// GET /GE/person/add?key=1&name=King%20George%20VI
	
	

}
