package uk.ac.le.cs.CO3098.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/GE/person")
public class geController {
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public @ResponseBody boolean add(
			@RequestParam(value="key") String key,
			@RequestParam(value="name") String name,
			@RequestParam(value="dob") String dob,
			@RequestParam(value="m") String m,
			@RequestParam(value="f") String f,
			@RequestParam(value="g") String g
			)
	 {
		
		System.out.println("The name is ");
		System.out.println(name);
		
		return false;
		
	}

}
