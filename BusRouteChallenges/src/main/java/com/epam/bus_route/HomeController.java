package com.epam.bus_route;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private DirectionsService directsService = new DirectionsService();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/direct", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Direction checkDirection(@RequestParam("dep_sid") int depSid, @RequestParam("arr_sid") int arrSid) {
		
		return directsService.getCurrentDirection(depSid, arrSid);
	}

}
