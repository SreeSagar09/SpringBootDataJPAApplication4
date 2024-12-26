package com.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@Component
public class TestRunner implements ApplicationRunner{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("From run method in TestRunner class.");
		
		System.out.println("------ To get record by findByEmployeeCode(String employeeCode) method ------");
		Employee employee1 = employeeRepository.findByEmployeeId(2);
		if(employee1 != null) {
			System.out.println(employee1.getEmployeeId()+" --> "+employee1.getEmployeeName()+"["+employee1.getEmployeeCode()+"]");
		}
		
		System.out.println("---- To get records by findByEmployeeCode(String employeeCode) method ----");
		List<Employee> employeeList1 = employeeRepository.findByEmployeeCode("A003");
		employeeList1.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("---- To get records by findByEmployeeName(String employeeName) method ----");
		List<Employee> employeeList2 = employeeRepository.findByEmployeeName("Sree Sagar");
		employeeList2.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("----- To get records by findByAge(Integer age) method -----");
		List<Employee> employeeList3 = employeeRepository.findByAge(27);
		employeeList3.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getAge());
		});
		
		System.out.println("----- To get records by findByDesignation(String designation) method -----");
		List<Employee> employeeList4 = employeeRepository.findByDesignation("QA Engineer");
		employeeList4.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getDesignation());
		});
	
		System.out.println("----- To get records by findByEmployeeNameAndEmployeeCode(String employeeName, String employeeCode) method -----");
		List<Employee> employeeList5 = employeeRepository.findByEmployeeNameAndEmployeeCode("Rakesh","A006");
		employeeList5.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("----- To get records by findByEmployeeNameOrEmploEmployeeCode(String employeeName, String employeeCode) method -----");
		List<Employee> employeeList6 = employeeRepository.findByEmployeeNameOrEmployeeCode("Sree sagar", "A002");
		employeeList6.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("----- To get records by findByAgeLessThanEqual(Integer age) method -----");
		List<Employee> employeeList7 = employeeRepository.findByAgeLessThanEqual(27);
		employeeList7.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getAge());
		});
		
		System.out.println("----- To get records by findByDesignationOrderByEmployeeNameAsc(String designation) method -----");
		List<Employee> employeeList8 = employeeRepository.findByDesignationOrderByEmployeeNameAsc("Software Engineer");
		employeeList8.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getAge());
		});
	}

}
