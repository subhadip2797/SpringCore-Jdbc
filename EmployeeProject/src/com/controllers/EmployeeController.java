package com.controllers;

import com.model.Employee;
import com.services.EmployeeServices;

import java.util.Scanner;


public class EmployeeController {
	
	private static Scanner sc = new Scanner(System.in);
	/*private EmployeeServices empService = new EmployeeServices();*/
	EmployeeServices empService;
	
	public void setEmpService(EmployeeServices empService)
	{
		this.empService = empService;
	}
	
	
	public long addEmployee()
	{
		try
		{
			System.out.println("\n***** Add Employee *****");
			System.out.print("\nEnter Employee Name :- ");
			String empName = sc.nextLine();
			System.out.print("Enter Employee Age :- ");
			String empAge = sc.nextLine();
			System.out.print("Enter Employee Address :- ");
			String empAddress = sc.nextLine();
			Employee emp = new Employee();
			emp.setEmpName(empName);
			emp.setEmpAge(Integer.parseInt(empAge));
			emp.setEmpAddress(empAddress);
			return empService.addEmployee(emp);
		}
		catch(Exception ex)
		{
			System.out.println("Add method could not be completed...");
            //ex.printStackTrace();
		}
		return 0;
	}
	
	public String displayAllEmployees()
	{
		return empService.getEmployee();
	}
	
	public Employee displayEmployeeById()
	{
		try
		{
			System.out.println("\n***** Display Employee By Id *****");
			System.out.print("\nEnter the Employee ID :- ");
			String empId = sc.nextLine();
			return empService.getEmployeeById(Long.parseLong(empId));
		}
		catch(Exception ex)
		{
			System.out.println("Display method cannot be completed...");
			//ex.printStackTrace();
		}
		return null;	
	}
	
	public boolean deleteEmployee()
	{
		try
		{
			System.out.println("\n***** Delete Employee *****");
			System.out.print("\nEnter the Employee ID :- ");
			String empId = sc.nextLine();
			return empService.deleteEmployee(Long.parseLong(empId));
		}
		catch(Exception ex)
		{
			System.out.println("Display method cannot be completed...");
			//ex.printStackTrace();
		}
		return false;
	}
	
	public void updateEmployeeDetails()
	{
		System.out.println("\n***** Update Employee Details *****");
		boolean flag = true;
		System.out.print("\nEnter the Employee Id to Update :- ");
		String id = sc.nextLine();
		long longId = Long.MIN_VALUE;
		System.out.println();
		while(flag)
		{
			System.out.println("\nSelect the field to update -----\n1.Update Name\n2.Update Age\n3.Update Address\n99.Terminate");
			String rawChoice = sc.nextLine();
			System.out.println("You entered the choice "+rawChoice);
			int intChoice = Integer.MIN_VALUE;
			try
			{
				longId = Long.parseLong(id);
				intChoice = Integer.parseInt(rawChoice);
				
				switch(intChoice)
				{
					case 1:
						System.out.print("\nEnter updated name :- ");
						String name = sc.nextLine();
						long updatedNameId = empService.updateEmployeeName(name, longId);
						if(updatedNameId!=0)
						{
							System.out.println("Employee name updated for "+updatedNameId);
						}
						else
						{
							System.out.println("Employee not present");
						}
						break;
					case 2:
						System.out.print("\nEnter updated age :- ");
						String age = sc.nextLine();
						long updatedAgeId = empService.updateEmployeeAge(Integer.parseInt(age), longId);
						if(updatedAgeId!=0)
						{
							System.out.println("Employee name updated for "+updatedAgeId);
						}
						else
						{
							System.out.println("Employee not present");
						}
						break;
					case 3:
						System.out.print("\nEnter updated address :- ");
						String address = sc.nextLine();
						long updatedAddressId = empService.updateEmployeeAddress(address, longId);
						if(updatedAddressId!=0)
						{
							System.out.println("Employee name updated for "+updatedAddressId);
						}
						else
						{
							System.out.println("Employee not present");
						}
						break;
					case 99:
						flag = false;
						break;
					default:
						break;
				}
			}
			catch(Exception ex)
			{
				System.out.println("You have Entered an Invalid Input. \nTo go Back Enter 1 ; else Enter to terminate");
				rawChoice = sc.nextLine();
                try
                {
                    intChoice = Integer.parseInt(rawChoice);
                } catch (Exception exp) 
                {
                    flag = false;
                }
                switch (intChoice)
                {
                    case 1:
                        flag = true;
                        break;
                    default:
                        flag = false;
                        break;
                }
			}
		}
	}
	
	public void handleRequest()
	{
		System.out.println("\n///*********** Welcome To Employee Registration System ***********///\n\n");
		boolean flag = true;
		while(flag)
		{
			System.out.println("\nSelect an option -----\n 1.Add Employee \n 2.Display all Employee \n 3.Display Employee by Id \n 4.Delete Employee \n 5.Update Employee Details \n 99.Terminate");
			System.out.print("Enter your choice :-");
			String rawInput = sc.nextLine();
	        System.out.println("You entered the Input  " + rawInput);
	        int intInput = Integer.MIN_VALUE;
	        try
	        {
	        	intInput = Integer.parseInt(rawInput);
	        	switch(intInput)
	        	{
	        	case 1:
	        		long addId = addEmployee();
	        		System.out.println("Added Employee Generated ID: " +addId);
	        		System.out.println();
	        		break;
	        	case 2:
	        		System.out.println("\nEmployee Id\t\tEmployee Name\t\tEmployee Age\t\tEmployee Address");
	        		System.out.println(displayAllEmployees());
	        		System.out.println();
	        		break;
	        	case 3:
	        		Employee emp = displayEmployeeById();
	        		if(emp!=null)
	        		{
	        			System.out.println("\nEmployee Id\t\tEmployee Name\t\tEmployee Age\t\tEmployee Address");
	        			System.out.println(emp);
	        			System.out.println();
	        		}
	        		else
	        		{
	        			System.out.println("Employee not present\n");
	        		}
	        		break;
	        	case 4:
	        		if(deleteEmployee())
	        		{
	        			System.out.println("Employee details deleted\n");
	        		}
	        		else
	        		{
	        			System.out.println("Employee not present...\n");
	        		}
	        		break;
	        	case 5:
	        		updateEmployeeDetails();
	        		System.out.println();
	        		break;
	        	case 99:
	        		flag = false;
	        		break;
	        	default:
	        		break;
	        	}
	        }
	        catch(Exception ex)
	        {
	        	 System.out.println("You have Entered an Invalid Input./n To go Back Enter 1 ; else Enter to terminate");
	             rawInput = sc.nextLine();
	             try 
	             {
	            	 intInput = Integer.parseInt(rawInput);
	             } 
	             catch(Exception exp) 
	             {
	            	 flag = false;
	             }
	             switch (intInput)
	             {
	             	case 1:	
	                    flag = true;
	                    break;
	                default:
	                    flag = false;
	                    break;
	             }
	        }
		}
		sc.close();
	}

}
