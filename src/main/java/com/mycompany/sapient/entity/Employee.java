package com.mycompany.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mycompany.sapient.bean.EmployeeBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name = "AGE")
	private Integer age;
	
	public EmployeeBean fetchEmployeeBean() {
		EmployeeBean emp = new EmployeeBean();
		emp.setAge(age);
		emp.setEmployeeId(employeeId);
		emp.setEmployeeName(employeeName);
		return emp;
	}
}
