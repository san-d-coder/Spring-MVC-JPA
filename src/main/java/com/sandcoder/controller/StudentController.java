package com.sandcoder.controller;

import java.sql.SQLException;

public interface StudentController {

	void getStudents() throws SQLException;

	void getStudent(int id) throws SQLException;

	void addStudent(int id, String name, String address) throws SQLException;

	void updateStudent(int id, String name, String address) throws SQLException;

	void deleteStudent(int id) throws SQLException;

}