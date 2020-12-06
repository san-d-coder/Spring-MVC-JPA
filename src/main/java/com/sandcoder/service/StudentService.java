package com.sandcoder.service;

import java.sql.SQLException;

import com.sandcoder.model.Student;

public interface StudentService {

	void getStudent(int id) throws SQLException;

	void addStudent(Student student) throws SQLException;

	void updateStudent(int id, Student student) throws SQLException;

	void deleteStudent(int id) throws SQLException;

	void getStudents() throws SQLException;

}