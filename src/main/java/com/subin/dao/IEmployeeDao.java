package com.subin.dao;

import java.util.List;

import com.subin.entity.Employee;

public interface IEmployeeDao {

	List<Employee> get();
	
	boolean save(Employee employee);
	
	Employee get(int id);
	
	boolean update(Employee employee);
	
	boolean delete(int id);
}
