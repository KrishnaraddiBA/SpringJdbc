package com.springJDBC123.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springJDBC123.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int createData(Employee employee) {
		String query="insert into employee(id,name,company) values(?,?,?)";
		int update = jdbcTemplate.update(query,employee.getId(),employee.getName(),employee.getCompany());
		return update;
	}

	@Override
	public int deleteData(Employee employee) {

		String query="delete from employee where id=?";
		int update = jdbcTemplate.update(query,employee.getId());
		return update;
	}

	@Override
	public int updateData(Employee employee) {

		String query="update employee set name=?, company=? where id=? ";
		int update = jdbcTemplate.update(query,employee.getName(),employee.getCompany(),employee.getId());
		return update;
	}

	@Override
	public Employee getEmployee(int empId) {

		String query="select * from employee where id=?";
		RowMapper<Employee> rowMapper=new RowMapperImpl();
		Employee employee = jdbcTemplate.queryForObject(query, rowMapper, empId);
		return employee;
	}

	@Override
	public List<Employee> findAll() {

		String query="select * from employee";
		List<Employee> query2 = jdbcTemplate.query(query, new RowMapperImpl());
		
		return query2;
	}

}
