package com.sandcoder.repository;

import com.sandcoder.model.Student;

public interface StudentRepository {

	String addStudent(Student student);

	void getStudent(int id);

	void getStudents();

	String updateStudent(int id, Student student);

	String deleteStudent(int id);

}