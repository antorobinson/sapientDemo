package com.mycompany.sapient.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.sapient.bean.EmployeeBean;
import com.mycompany.sapient.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee-management")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeBean> addEmployee(@RequestBody EmployeeBean employee){
		
		EmployeeBean employeeBean = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeBean);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Map<String,Object>> getEmployees(
			@RequestParam(value = "employeeName", required = false) String employeeName,
			@RequestParam(value = "page", defaultValue = "0") int page, 
			@RequestParam(value = "size", defaultValue = "2") int size,
			@RequestParam(value = "sort", defaultValue = "employeeId,asc") String[] sort
			){
		
		List<Order> orderList = new ArrayList<Order>();
		if(sort[0].contains(",")) {
			for(String sort1:sort) {
				String[] _sort = sort1.split(",");
				orderList.add(new Order(getSortDirection(_sort[1]),_sort[0]));
			}
		}
		else
			orderList.add(new Order(getSortDirection(sort[1]), sort[0]));
		
		Pageable paging = PageRequest.of(page, size, Sort.by(orderList));
		
		Map<String,Object> employeeBeanList = employeeService.getEmployees(paging, employeeName);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeBeanList);
	}
	
	private Sort.Direction getSortDirection(String val){
		if(val.equalsIgnoreCase("asc"))
			return Sort.Direction.ASC;
		else if (val.equalsIgnoreCase("desc"))
			return Sort.Direction.DESC;
		return null;
	}
}
