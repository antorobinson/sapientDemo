package com.mycompany.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mycompany.sapient.bean.DepartmentBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@Column(name="DEPARTMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	
	public DepartmentBean fetchDepartmentBean() {
		DepartmentBean dept = new DepartmentBean();
		dept.setDepartmentId(departmentId);
		dept.setDepartmentName(departmentName);
		return dept;
	}
}
