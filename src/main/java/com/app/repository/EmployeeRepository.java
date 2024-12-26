package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByEmployeeId(Integer employeeId);
	
	public List<Employee> findByEmployeeCode(String employeeCode);
	
	public List<Employee> findByEmployeeName(String employeeName);
	
	public List<Employee> findByAge(Integer age);
	
	public List<Employee> findByDesignation(String designation);
	
	public List<Employee> findByEmployeeNameAndEmployeeCode(String employeeName, String employeeCode);
	
	public List<Employee> findByEmployeeNameOrEmployeeCode(String employeeName, String employeeCode);
	
	public List<Employee> findByAgeLessThanEqual(Integer age);
	
	public List<Employee> findByDesignationOrderByEmployeeNameAsc(String designation);
}
