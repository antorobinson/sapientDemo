package com.mycompany.sapient.bean;

import com.mycompany.sapient.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBean {

	private Long employeeId;
	private String employeeName;
	private Integer age;
	private DepartmentBean department;
	
	public Employee fetchEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setAge(age);
		employee.setDepartment(department.fetchDepartment());
		return employee;
	}
}
