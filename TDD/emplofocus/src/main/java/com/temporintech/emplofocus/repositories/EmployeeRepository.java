package com.temporintech.emplofocus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temporintech.emplofocus.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
