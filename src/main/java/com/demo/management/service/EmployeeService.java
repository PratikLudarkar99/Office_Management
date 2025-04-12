package com.demo.management.service;

import com.demo.management.model.Designation;
import com.demo.management.model.Employee;
import com.demo.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentDepartmentId(departmentId);
    }

    public Page<Employee> getEmployeesByCriteria(Designation designation, Double minSalary, Double maxSalary, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByCriteria(designation, minSalary, maxSalary, pageable);
    }

}

