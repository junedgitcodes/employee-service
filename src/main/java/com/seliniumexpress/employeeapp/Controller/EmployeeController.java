package com.seliniumexpress.employeeapp.Controller;

import com.seliniumexpress.employeeapp.Entity.Employee;
import com.seliniumexpress.employeeapp.Model.EmployeeResponse;
import com.seliniumexpress.employeeapp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    private ResponseEntity<EmployeeResponse> getEmployee(@PathVariable int id) {
        EmployeeResponse employeeResponse = employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @PostMapping("/employee")
    private Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

}
