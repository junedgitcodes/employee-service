package com.seliniumexpress.employeeapp.Repository;

import com.seliniumexpress.employeeapp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
}
