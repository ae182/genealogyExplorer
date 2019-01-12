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

import com.google.gson.Gson;

import uk.ac.le.cs.CO3098.spring.domain.APerson;
import uk.ac.le.cs.CO3098.spring.domain.JsonR;
import uk.ac.le.cs.CO3098.spring.domain.Parents2;
import uk.ac.le.cs.CO3098.spring.service.PersonService;

@Controller
@RequestMapping("/GE/person")
public class geController {
	
	@Autowired
	public PersonService personService; 
	
	// Returns view below here 
	
	// This return the create person view 
	 @RequestMapping(value = "/create")
    public ModelAndView create(){	
    	  return new ModelAndView("create");    
    } 
	
	// API calls below here 

	 @RequestMapping(value = "/landin")
	    public ModelAndView landin(){	
	    	  return new ModelAndView("landin");    
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
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Object get(@PathVariable String id) {
		Object o;
		Gson gson= new Gson();		
		APerson personInfo = personService.getPerson(id);
		
		if (personInfo == null ) {
			
			JsonR jmess = new JsonR("Person does not exist");
			
			o=jmess;
			
		} else {
			
			o= gson.toJson(personInfo);
		}
		return o;
				
	}
		
	//@RequestMapping(value = {"/ancestors/{id}"})
	
	// POST /GE/person/savePerson 
//	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
//	public @ResponseBody Object savePerson(@RequestBodyAPerson person) {
//			
//			/*
//			@RequestParam(value="name") String name,
//			@RequestParam(value="dob") String dob,
//			@RequestParam(value="gender") String gender,
//			@RequestParam(value="mothersKey") String mothersKey,
//			@RequestParam(value="fathersKey") String fathersKey,
//			@RequestParam(value="specialKey") String specialKey
//			) {*/
//			
//		System.out.println("Inside the submit method ");
//				
//		personService.savePerson(new APerson(specialKey, name, dob, mothersKey, fathersKey, gender)); 
//		
//        //return new ModelAndView("redirect:/GE/person/listAll");
//		return "New Save controller method";
//	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView savePerson(APerson p){
		personService.savePerson(p);
        return new ModelAndView("redirect:listAll");
        
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
	
	@RequestMapping(value = "/ancestors/{id}")
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

	@RequestMapping(value="/ancestors/{id}", method=RequestMethod.GET)
	public @ResponseBody String ancestorsTwo(@PathVariable String id) {
		
		System.out.println("It's working");
		
		// return that person object 
		APerson person = personService.getPerson(id);
				
		person.setAncestors(personService.getParentTwo(id));
		
		System.out.println("It's working");
				
		return "something";
	
	}
	
	// GET /GE/person/add?key=11&name=Prince%20George&m=10&f=8
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public @ResponseBody String add(
			@RequestParam(value="key") String key,
			@RequestParam(value="name") String name,
			@RequestParam(value="m", required = false) String m,
			@RequestParam(value="f", required = false) String f
			)
	 {
		
		APerson person = personService.getPerson(key);
		
		personService.setPersonsMotherAndFather(f, m,person.getSpecialKey());
		
		System.out.println( person.getName() );
		
		//return "Updating tree for " + person.getName();
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
