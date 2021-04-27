package com.services;

import com.model.Employee;
import com.dao.*;

import java.util.*;

public class EmployeeServices {
	
	private static HashMap<Long, Employee> employeeMap = new HashMap<Long, Employee>();
	//private static long employeeIdCounter = 1;
	//private EmployeeDAO empDao = new EmployeeDAO();
	private EmployeeDAO empDao;
	
	public void setEmpDao(EmployeeDAO empDao)
	{
		this.empDao = empDao;
	}
	
	public long getLastEmployeeId()
	{
		long employeeIdCounter = empDao.getLastEmployeeId();
		return employeeIdCounter;
	}
	
	public long addEmployee(Employee employee)
	{
		long lastId = getLastEmployeeId();
		employee.setEmpId(++lastId);
		//employeeMap.put(employeeIdCounter, employee);
		//employeeIdCounter++;
		
		//return employee.getEmpId();
		return empDao.addEmployee(employee);
		
	}
	
	public String getEmployee()
	{
		employeeMap = empDao.getEmployee();
		List<Employee> valueList = new ArrayList<Employee>(employeeMap.values());
		return valueList.toString();
	}
	
	public Employee getEmployeeById(long id)
	{
		/*if(employeeMap.containsKey(id))
		{
			return employeeMap.get(id);
		}
		return null;*/
		Employee emp = new Employee();
		emp = empDao.getEmployeeById(id);
		return emp;
	}
	
	public boolean deleteEmployee(long id)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.remove(id);
			return true;
		}
		return false;*/
		boolean res = empDao.deleteEmployee(id);
		return res;
	}
	
	public long updateEmployeeName(String name, long id)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.get(id).setEmpName(name);
			return employeeMap.get(id).getEmpId();
		}
		return 0;*/
		boolean res = empDao.updateEmployeeName(name, id);
		if(res)
		{
			return id;
		}
		else 
		{
			return 0;
		}
	}
	
	public long updateEmployeeAge(int age, long id)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.get(id).setEmpAge(age);
			return employeeMap.get(id).getEmpId();
		}
		return 0;*/
		boolean res = empDao.updateEmployeeAge(age, id);
		if(res)
		{
			return id;
		}
		else 
		{
			return 0;
		}
	}
	
	public long updateEmployeeAddress(String address, long id)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.get(id).setEmpAddress(address);
			return employeeMap.get(id).getEmpId();
		}
		return 0;*/
		boolean res = empDao.updateEmployeeAddress(address, id);
		if(res)
		{
			return id;
		}
		else 
		{
			return 0;
		}
		
	}
}
