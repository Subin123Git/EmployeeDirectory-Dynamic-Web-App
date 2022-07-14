package com.subin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subin.dao.EmployeeDaoImpl;
import com.subin.entity.Employee;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Create Reference Variable for EmployeeDaoImpl
	EmployeeDaoImpl employeeDaoImpl = null;
	
	//Create Constructor and initialize employee dao
	public EmployeeController() {
	 employeeDaoImpl = new EmployeeDaoImpl();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//call Dao method to get list of employees
		List<Employee> employeeList = employeeDaoImpl.get();
		
		//Add the employeeList to the Request Object
		request.setAttribute("employeeList", employeeList);
		  
		//Get the Request Dispatcher
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
		
		//Forward the request and response
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
