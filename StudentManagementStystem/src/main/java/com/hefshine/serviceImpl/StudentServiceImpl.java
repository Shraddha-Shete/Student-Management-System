package com.hefshine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hefshine.entity.Student;
import com.hefshine.repository.StudentRepository;
import com.hefshine.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}
	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

}
