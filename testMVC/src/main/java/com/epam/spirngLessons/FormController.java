package com.epam.spirngLessons;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String form(@ModelAttribute User user) {
		return "form";
	}
	
	@RequestMapping(value="/get-json-user", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public User getJSONUser(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		return user;
		
	}
	
	@RequestMapping(value = "/check-user", method = RequestMethod.GET)
	public String checkUser(@ModelAttribute("user") User user) 
	{
//		if (user.getEmail() != null)
//			return "redirect:/upload-file";
//		else
			return "form";
		
	}
}
