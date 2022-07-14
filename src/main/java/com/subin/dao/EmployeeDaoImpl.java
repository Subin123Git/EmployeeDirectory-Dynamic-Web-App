package com.subin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.subin.entity.Employee;
import com.subin.util.DBConnectionUtil;

public class EmployeeDaoImpl implements IEmployeeDao {


	Connection con = null;

	Statement statement = null;

	ResultSet resultSet = null;

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

}
