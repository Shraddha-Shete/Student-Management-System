package com.hefshine.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.entity.Student;
import com.hefshine.service.StudentService;

@RestController
@CrossOrigin("*")

public class StudentController {
	@Autowired
	StudentService studentService;
	@PostMapping("save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	@GetMapping("list")
	public List<Student> findAllStudent(){
		return studentService.findAllStudent();
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable("id") int id) {
		 studentService.delete(id);
	}
	@GetMapping("find/{id}")
	public Student findStudent(@PathVariable("id") int id) {
		return studentService.findById(id);
	}
	
	@PutMapping("update/{id}")
	public Student update(@PathVariable("id") int id, @RequestBody Student req) {
	    Student student=studentService.findById(id);
	    student.setEmail(req.getEmail());
	    student.setName(req.getName());
	    student.setMobNo(req.getMobNo());
	    student.setId(req.getId());
		return studentService.saveStudent(req); 
	}
}
