package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringsLessonsApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		Student Yurii = new Student (1, "Yurii", "Rudzinskyi");
		Student Oleg = new Student (2, "Oleg", "Pavlikovskyi");
		Student Janna = new Student (5, "Janna", "Serpuh");
//		studentDAO.insert(Yurii);
//		studentDAO.insert(Oleg);
//		studentDAO.insert(Janna);
		
		Student someStudent = studentDAO.findByLastName("Serpuh");
		Logger logger = (Logger) context.getBean("logger");
		System.out.println(logger);
		
	}
}
