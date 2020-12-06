package com.sandcoder.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandcoder.model.Student;
import com.sandcoder.repository.StudentRepository;



@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	private String result;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public void getStudents() throws SQLException {
		studentRepository.getStudents();
	}
	
	@Override
	public void getStudent(int id) throws SQLException {
		if(id > 0)
			studentRepository.getStudent(id);
		else
			System.out.println("Invalid Input for Id: "+id);
	}
	
	
	@Override
	public void addStudent(Student student) throws SQLException {
		if(student.getId()>0 && student.getName() != null && student.getAddress() != null)
			{
				result = studentRepository.addStudent(student);
				System.out.println(result);
			}
		else
			System.out.println("Invalid Input for Student: "+student.toString());
	}
	
	@Override
	public void updateStudent(int id, Student student) throws SQLException {
		if(student.getId()>0 && student.getName() != null && student.getAddress() != null)
			{
				result = studentRepository.updateStudent(id,student);
				System.out.println(result);
			}
			
		else
			System.out.println("Invalid Input for Student: "+student.toString());
	}
	
	@Override
	public void deleteStudent(int id) throws SQLException {
		if(id > 0)
			{
				result = studentRepository.deleteStudent(id);
				System.out.println(result);
			}
		else
			System.out.println("Invalid Input for Id: "+id);
	}

}
