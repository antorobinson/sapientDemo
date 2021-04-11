package com.mycompany.sapient.jpa;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import com.mycompany.sapient.entity.Employee;
import com.mycompany.sapient.entity.Department;

public class EmployeeSpecification {

	public static Specification<Employee> hasEmployeeName(String employeeName){
		if(employeeName == null) {
			return null;
		} else {
			return (root, query, cb) -> {
				return cb.like(cb.lower(root.get("employeeName")), employeeName.toLowerCase());
			};
		}
	}
	
	public static Specification<Employee> hasAge(Integer age){
		if(age == null) {
			return null;
		} else {
			return (root, query, cb) -> {
				return cb.equal(cb.toInteger(root.get("age")), age);
			};
		}
	}
	
	public static Specification<Employee> hasDeptId(Long deptId){
		if(deptId == null) {
			return null;
		} else {
			return (root, query, cb) -> {
				Join<Employee, Department> deptJoin = root.join("department", JoinType.LEFT);
				return cb.equal(cb.toLong(deptJoin.get("departmentId")), deptId);
			};
		}
	}
	
}
