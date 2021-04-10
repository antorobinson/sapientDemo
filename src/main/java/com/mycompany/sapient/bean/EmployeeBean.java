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
	
	public Employee fetchEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setAge(age);
		return employee;
	}
}
