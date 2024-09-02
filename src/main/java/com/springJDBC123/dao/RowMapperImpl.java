package com.springJDBC123.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springJDBC123.entity.Employee;

public class RowMapperImpl implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee employee=new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setCompany(rs.getString(3));
		return employee;
	}

}
