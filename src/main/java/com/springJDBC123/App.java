package com.springJDBC123;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springJDBC123.dao.EmployeeDao;
import com.springJDBC123.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	Scanner scan=new Scanner(System.in);
    	System.out.println("Hi all i am starting spring jdbc");
    	
    	ApplicationContext context= new ClassPathXmlApplicationContext("com/springJDBC123/CrudConfig.xml");
    	EmployeeDao bean = context.getBean("employeedao", EmployeeDao.class);
    	
    	boolean flag=true;
    	while (flag) {
			System.out.println("hit 1 to create a data");
			System.out.println("hit 2 to delete a data");
			System.out.println("hit 3 to update a data");
			System.out.println("hit 4 to fetch a data");
			System.out.println("hhit 5 to fetch all the data");
			
			int key=scan.nextInt();
			switch (key) {
			case 1:
				//this is for the creating an object
		    	Employee emp=new Employee();
		    	emp.setId(102);
		    	emp.setName("Mallikarjun");
		    	emp.setCompany("NopalCyber");
		    	bean.createData(emp);
				break;
			case 2:
				//this is for deleting a data
		    	Employee emp1=new Employee();
		    	emp1.setId(102);
		    	bean.deleteData(emp1);
		    	System.out.println("employee deleted succesfully!!");
		    	
				break;
			case 3:
				//this is for the updating a data
		    	Employee emp2=new Employee();
		    	emp2.setName("Keshav");
		    	emp2.setCompany(null);
		    	emp2.setId(102);
		    	bean.updateData(emp2);
		    	System.out.println("employee updated succesfully");
				break;
			case 4:
				
				//this is for fetching a data
		    	Employee employee = bean.getEmployee(102);
		    	System.out.println(employee);
				break;
			case 5:
				//this is for fetching all the employees
		    	
		    	List<Employee> findAll = bean.findAll();
		    	for (Employee employee2 : findAll) {
					System.out.println(employee2);
				}
				break;

			default:
				System.out.println("u have entered an inalid input please try rerunning a application");
				flag=false;
				break;
			}
		}
    	
    	
    	
    	
    	
    
    	
    	
    	
    	
    	
    }
}
