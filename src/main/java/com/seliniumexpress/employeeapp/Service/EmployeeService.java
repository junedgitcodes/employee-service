package com.seliniumexpress.employeeapp.Service;


import com.seliniumexpress.employeeapp.Entity.Employee;
import com.seliniumexpress.employeeapp.Model.EmployeeResponse;
import com.seliniumexpress.employeeapp.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse getEmployee(int id) {

        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null; // or handle the case where the employee is not found
        }
        return modelMapper.map(employee, EmployeeResponse.class);
//        return employeeResponse;
    }

    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }
}
