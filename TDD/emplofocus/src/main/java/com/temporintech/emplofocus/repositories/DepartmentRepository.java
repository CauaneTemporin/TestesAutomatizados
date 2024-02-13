package com.temporintech.emplofocus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temporintech.emplofocus.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
