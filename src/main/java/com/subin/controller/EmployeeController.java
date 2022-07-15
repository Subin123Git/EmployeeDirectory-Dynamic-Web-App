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

	RequestDispatcher requestDispatcher = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if(action == null)
			action = "LIST";

		switch(action)
		{
		case "LIST":
			listEmployees(request, response);
			break;

		case "EDIT":
			listSingleEmployee(request, response);
			break;

		case "DELETE":
			deleteSingleEmployee(request, response);
			break;

		default:
			listEmployees(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String employeeId = request.getParameter("employeeid");
		String name = request.getParameter("employeename");
		String contactNo = request.getParameter("contactno");
		String emailId = request.getParameter("emailid");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String hotelId = request.getParameter("hotelid");

		System.out.println(name);
		System.out.println(employeeId);

		Employee employeeAdd = new Employee();

		employeeAdd.setEmployeeName(name);
		employeeAdd.setEmployeeContactNumber(contactNo);
		employeeAdd.setEmployeeEmailId(emailId);
		employeeAdd.setEmployeeAge(Integer.parseInt(age));
		employeeAdd.setEmployeeGender(gender);
		employeeAdd.setHotelId(Integer.parseInt(hotelId));

		if(employeeId.isEmpty() || employeeId == null)
		{
			if(employeeDaoImpl.save(employeeAdd))
			{
				request.setAttribute("message","Added Successfully");

			}
		}
		else
		{
			employeeAdd.setEmployeeId(Integer.parseInt(employeeId));
			if(employeeDaoImpl.update(employeeAdd))
			{
				System.out.println("Reached Update if statement");
				request.setAttribute("message","Updated Successfully");

			}
		}

		listEmployees(request,response);
	}

	public void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//call Dao method to get list of employees
		List<Employee> employeeList = employeeDaoImpl.get();

		//Add the employeeList to the Request Object
		request.setAttribute("employeeList", employeeList);

		//Get the Request Dispatcher
		requestDispatcher = request.getRequestDispatcher("/views/employee-list.jsp");

		//Forward the request and response
		requestDispatcher.forward(request, response);
	}

	public void listSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		Employee editEmployee = employeeDaoImpl.get(Integer.parseInt(id));

		request.setAttribute("editEmployee", editEmployee);

		//Get the Request Dispatcher
		requestDispatcher = request.getRequestDispatcher("/views/employee-add.jsp");

		//Forward the request and response
		requestDispatcher.forward(request, response);

	}

	public void deleteSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("id");

		if(employeeDaoImpl.delete(Integer.parseInt(id)))
		{
			request.setAttribute("message", "Employee Deleted Successfully");
		}

		listEmployees(request, response);
	}
}
