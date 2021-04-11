package com.mycompany.sapient.bean;

import com.mycompany.sapient.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentBean {

	private Long departmentId;
	private String departmentName;
	
	public Department fetchDepartment() {
		Department department = new Department();
		department.setDepartmentId(departmentId);
		department.setDepartmentName(departmentName);
		return department;
	}
}
