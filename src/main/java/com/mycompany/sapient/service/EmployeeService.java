package com.mycompany.sapient.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.sapient.bean.EmployeeBean;
import com.mycompany.sapient.entity.Employee;
import com.mycompany.sapient.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	public EmployeeBean addEmployee(EmployeeBean emp) {
		Employee employee = emp.fetchEmployee();
		employeeRepo.save(employee);
		
		return employee.fetchEmployeeBean();
	}
	
	public Map<String,Object> getEmployees(Pageable page){
		Page<Employee> employeeList = employeeRepo.findAll(page);
		List<EmployeeBean> empBeanList = employeeList.getContent().stream().map(e-> e.fetchEmployeeBean()).collect(Collectors.toList());
		
		Map<String,Object> responseMap = new HashMap<String, Object>();
		
		responseMap.put("employees", empBeanList);
		responseMap.put("currentPage", employeeList.getNumber());
		responseMap.put("totalPages", employeeList.getTotalPages());
		responseMap.put("totalElements", employeeList.getTotalElements());
		return responseMap;
	}
}
