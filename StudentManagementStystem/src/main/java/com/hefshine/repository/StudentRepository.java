package com.hefshine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
