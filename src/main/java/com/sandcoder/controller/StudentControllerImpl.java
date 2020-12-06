package com.sandcoder.controller;

import java.sql.SQLException;

import com.sandcoder.model.Student;
import com.sandcoder.service.StudentService;
import com.sandcoder.service.StudentServiceImpl;

public class StudentControllerImpl implements StudentController {
	
	private StudentService studentService;
	private Student student;
	
	public StudentControllerImpl() {
		studentService = new StudentServiceImpl();
	}
	
	@Override
	public void getStudents() throws SQLException {
		studentService.getStudents();
	}
	
	
	@Override
	public void getStudent(int id) throws SQLException {
		studentService.getStudent(id);
	}
	
	
	
	@Override
	public void addStudent(int id, String name, String address) throws SQLException {
		this.student = new Student();
		this.student.setId(id);
		this.student.setName(name);
		this.student.setAddress(address);
		this.studentService.addStudent(this.student);
	}
	
	
	@Override
	public void updateStudent(int id, String name, String address) throws SQLException {
		this.student = new Student();
		this.student.setId(id);
		this.student.setName(name);
		this.student.setAddress(address);
		this.studentService.updateStudent(id,this.student);
	}
	
	
	@Override
	public void deleteStudent(int id) throws SQLException {
		studentService.deleteStudent(id);
	}

}
