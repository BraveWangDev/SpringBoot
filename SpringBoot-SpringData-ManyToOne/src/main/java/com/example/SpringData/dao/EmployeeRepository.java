package com.example.SpringData.dao;

import com.example.SpringData.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Brave on 16/10/12.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

