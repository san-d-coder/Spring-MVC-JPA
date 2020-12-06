package com.sandcoder.literals;

public class StudentQueries {
	
	public final static String selectOne = "select s from Student s where s.id = :studentID";
	public final static String selectAll = "select s from Student s where s.id is not null";

}
