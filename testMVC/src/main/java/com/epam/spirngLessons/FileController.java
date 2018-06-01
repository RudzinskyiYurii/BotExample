package com.epam.spirngLessons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileController {

	@RequestMapping(value = "/upload-file", method=RequestMethod.GET)
	public String fileUpload () {
		String uploadMessageResult = "false";
		
		return "upload-file";
		
	}
	
}
