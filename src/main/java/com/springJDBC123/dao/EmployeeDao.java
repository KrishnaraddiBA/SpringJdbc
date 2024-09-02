package com.springJDBC123.dao;

import java.util.List;

import com.springJDBC123.entity.Employee;

public interface EmployeeDao {
	
	public int createData(Employee employee);
	public int deleteData(Employee employee);
	public int updateData(Employee employee);
	public Employee getEmployee(int empId);
	public List<Employee> findAll();

}
