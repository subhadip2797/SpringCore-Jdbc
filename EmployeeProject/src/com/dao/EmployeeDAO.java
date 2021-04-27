package com.dao;

import java.sql.*;
import com.connectionUtil.*;
import com.model.Employee;
import java.util.*;


public class EmployeeDAO {
	
	private static ConnectionUtil conUtil = new ConnectionUtil();
	
	private static Connection con = conUtil.getConnection();
	
	public long addEmployee(Employee emp)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("insert into Employee values(?,?,?,?)");
			stmt.setLong(1, emp.getEmpId());
			stmt.setString(2, emp.getEmpName());
			stmt.setInt(3, emp.getEmpAge());
			stmt.setString(4, emp.getEmpAddress());
			
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return emp.getEmpId();
			}
		} 
		catch (SQLException e)
		{
			System.out.println("Can not insert details");
			//e.printStackTrace();
		}
		return 0;
	}
	
	public HashMap<Long, Employee> getEmployee()
	{
		HashMap<Long, Employee> employeeMap = new HashMap<Long, Employee>();
		Employee emp = new Employee();
		try 
		{
			PreparedStatement stmt = con.prepareStatement("select * from Employee");
			ResultSet res = stmt.executeQuery();
			while(res.next())
			{
				emp.setEmpId(res.getLong(1));
				emp.setEmpName(res.getString(2));
				emp.setEmpAge(res.getInt(3));
				emp.setEmpAddress(res.getString(4));
				
				employeeMap.put(emp.getEmpId(), emp);
			}
			return employeeMap;
		} 
		catch (SQLException e)
		{
			System.out.println("Error Occurred...");
		}
		return null;
	}
	
	public Employee getEmployeeById(long id)
	{
		Employee emp = new Employee();
		
		try 
		{
			PreparedStatement stmt = con.prepareStatement("select * from Employee where empId=?");
			stmt.setLong(1, id);
			ResultSet res = stmt.executeQuery();
			while(res.next())
			{
				emp.setEmpId(res.getLong(1));
				emp.setEmpName(res.getString(2));
				emp.setEmpAge(res.getInt(3));
				emp.setEmpAddress(res.getString(4));
			}
			return emp;
		}
		catch (SQLException e)
		{
			System.out.println("Error Occurred...");
		}
		return null;
	}
	
	public boolean deleteEmployee(long id)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("delete from Employee where empId=?");
			stmt.setLong(1, id);
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return true;
			}
		} 
		catch (SQLException e)
		{
			System.out.println("Error Occurred...");
		}
		return false;
	}
	
	public boolean updateEmployeeName(String name, long id)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("update Employee set empName=? where empId=?");
			stmt.setString(1, name);
			stmt.setLong(2, id);
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return true;
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Error Occurred...");
		}
		return false;
	}
	
	public boolean updateEmployeeAge(int age, long id)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("update Employee set empAge=? where empId=?");
			stmt.setInt(1, age);
			stmt.setLong(2, id);
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return true;
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Error Occurred...");
		}
		return false;
	}
	
	public boolean updateEmployeeAddress(String address, long id)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("update Employee set empAddress=? where empId=?");
			stmt.setString(1, address);
			stmt.setLong(2, id);
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return true;
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Error Occurred...");
		}
		return false;
	}
	
	public long getLastEmployeeId()
	{
		long id = 0;
		try 
		{
			
			PreparedStatement stmt = con.prepareStatement("select empId from Employee where rownum <=1 order by empId desc");
			ResultSet res = stmt.executeQuery();
			while(res.next())
			{
				id = res.getLong(1);
			}
			return id;
		} 
		catch (SQLException e)
		{
			System.out.println("Error Occurred...");
			//e.printStackTrace();
		}
		return 0;
	}
	
}
