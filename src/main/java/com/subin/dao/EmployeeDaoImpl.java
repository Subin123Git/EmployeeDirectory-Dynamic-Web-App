package com.subin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.subin.entity.Employee;
import com.subin.util.DBConnectionUtil;

public class EmployeeDaoImpl implements IEmployeeDao {


	Connection con = null;

	Statement statement = null;

	ResultSet resultSet = null;
	
	PreparedStatement preparedStatement = null;

	@Override
	public List<Employee> get() {

		//Create Reference Variables
		List<Employee> employeeList = null;
		Employee employee = null;


		try {
			employeeList = new ArrayList<Employee>();

			//Create SQL Query
			String sqlQuery = "SELECT * FROM employee";

			//Get Connection
			con=DBConnectionUtil.openConnection();

			//Create Statement
			statement = con.createStatement();

			//Execute SQL query a
			resultSet = statement.executeQuery(sqlQuery);

			//Process the ResultSet
			while(resultSet.next())
			{
				employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setEmployeeName(resultSet.getString("employee_Name"));
				employee.setEmployeeContactNumber(resultSet.getString("employee_contact_number"));
				employee.setEmployeeEmailId(resultSet.getString("employee_email_id"));
				employee.setEmployeeAge(resultSet.getInt("employee_age"));
				employee.setEmployeeGender(resultSet.getString("employee_gender"));
				employee.setHotelId(resultSet.getInt("hotel_id"));
				employeeList.add(employee); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Return the List
		return employeeList;
	}

	@Override
	public boolean save(Employee employee) {
		
		boolean flag = false;
		 try {
			String sql = "INSERT INTO employee(employee_name, employee_contact_number, employee_email_id, employee_age, employee_gender, hotel_id) VALUES (?,?,?,?,?,?)";
			 con = DBConnectionUtil.openConnection();
			 System.out.println("Connected to db");
			 PreparedStatement prepareStatement = con.prepareStatement(sql);		 
			 prepareStatement.setString(1, employee.getEmployeeName());			 
			 prepareStatement.setString(2, employee.getEmployeeContactNumber());			 
			 prepareStatement.setString(3, employee.getEmployeeEmailId());			 
			 prepareStatement.setInt(4, employee.getEmployeeAge());			 
			 prepareStatement.setString(5, employee.getEmployeeGender());			 
			 prepareStatement.setInt(6, employee.getHotelId());			 
			 prepareStatement.executeUpdate();
			 flag = true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		 return flag;
	}

	@Override
	public Employee get(int id) {
		
		Employee editEmployee;
		
		 editEmployee = new Employee();
		try {
			String sql = "SELECT * FROM employee WHERE employee_id ="+id;
			
			con = DBConnectionUtil.openConnection();
			
			statement = con.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				editEmployee.setEmployeeId(resultSet.getInt("employee_id"));
				editEmployee.setEmployeeName(resultSet.getString("employee_Name"));
				editEmployee.setEmployeeContactNumber(resultSet.getString("employee_contact_number"));
				editEmployee.setEmployeeEmailId(resultSet.getString("employee_email_id"));
				editEmployee.setEmployeeAge(resultSet.getInt("employee_age"));
				editEmployee.setEmployeeGender(resultSet.getString("employee_gender"));
				editEmployee.setHotelId(resultSet.getInt("hotel_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Employee Name = "+editEmployee.getEmployeeName());
		return editEmployee;
	}

	@Override
	public boolean update(Employee employee) {
		
		boolean flag = false;
		
		try {
			
			String sql = "UPDATE employee SET employee_name=?,employee_contact_number=?,employee_email_id=?,employee_age=?,employee_gender=?,hotel_id=? WHERE employee_id=?";
			 con = DBConnectionUtil.openConnection();
			 System.out.println("Connected to db");
			 PreparedStatement prepareStatement = con.prepareStatement(sql);		 
			 prepareStatement.setString(1, employee.getEmployeeName());			 
			 prepareStatement.setString(2, employee.getEmployeeContactNumber());			 
			 prepareStatement.setString(3, employee.getEmployeeEmailId());			 
			 prepareStatement.setInt(4, employee.getEmployeeAge());			 
			 prepareStatement.setString(5, employee.getEmployeeGender());			 
			 prepareStatement.setInt(6, employee.getHotelId());			 
			 prepareStatement.setInt(7, employee.getEmployeeId());			 
			 prepareStatement.executeUpdate();
			 flag = true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean delete(int id) {
		
		boolean flag = false;
		
		String sql = "DELETE FROM employee WHERE employee_id ="+id;
		
		 try {
			con = DBConnectionUtil.openConnection();
			 
			 PreparedStatement prepareStatement = con.prepareStatement(sql);
			 
			 prepareStatement.executeUpdate();
			 
			 flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
