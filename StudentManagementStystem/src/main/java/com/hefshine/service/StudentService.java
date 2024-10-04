package com.hefshine.service;

import java.util.List;

import com.hefshine.entity.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> findAllStudent();
	public void delete(int id);
	public Student findById(int id);
	public Student updateStudent(Student student);
	
}
