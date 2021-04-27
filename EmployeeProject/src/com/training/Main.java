package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.controllers.EmployeeController;
//import java.util.Scanner;


public class Main {
	
	public static void main(String[] args)
	{
		/*EmployeeController empController = new EmployeeController();
		empController.handleRequest();*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeXml.xml");
		EmployeeController empController = (EmployeeController) context.getBean("empController");
		empController.handleRequest();
		
	}

}
