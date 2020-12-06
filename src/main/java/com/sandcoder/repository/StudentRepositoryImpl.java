package com.sandcoder.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sandcoder.literals.StudentQueries;
import com.sandcoder.model.Student;

public class StudentRepositoryImpl implements StudentRepository {
	
	//Define Entity Manager Factory
	private final EntityManagerFactory ENTITY_MANAGER_FACTORY =  
			Persistence.createEntityManagerFactory("mvcjpa");
	
	//Define Entity Transaction
	private EntityTransaction et = null;
	private EntityManager em = null;
	private Student student = null;
	private List<Student> students = null;
	private TypedQuery<Student> tq = null;
	
	@Override
	public String addStudent(Student student) {
		
		//Define Entity Manager
		em = ENTITY_MANAGER_FACTORY.createEntityManager();
		try {
			//Get Transaction
			et = em.getTransaction();
			
			//Begin Transaction as DML
			et.begin();
			
			//Save to DB
			em.persist(student);
			
			//Commit Transaction
			et.commit();
			
			return "Success";
		}
		
		catch(Exception e) {
			if(et!=null)
				et.rollback();
			e.printStackTrace();
			return "Failure";
		}
		
		finally {
			em.close();
		}
		
	}
	
	@Override
	public void getStudent(int id) {
		
		em = ENTITY_MANAGER_FACTORY.createEntityManager();
		try{
			tq =  em.createQuery(StudentQueries.selectOne,Student.class); 
			this.student = em.find(Student.class, id);
			if(this.student == null)
				System.out.println("Student with ID: "+id+" not found!");
			else
				System.out.println(student.toString());
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
			
	}
	
	@Override
	public void getStudents() {
		
		em = ENTITY_MANAGER_FACTORY.createEntityManager();
		try {
		tq = em.createQuery(StudentQueries.selectAll, Student.class);
		students = tq.getResultList();
		for(Student student: students)	{
			System.out.println(student.toString());
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}

	@Override
	public String updateStudent(int id, Student student) {
		
		em = ENTITY_MANAGER_FACTORY.createEntityManager();
		try {
		et = em.getTransaction();
		this.student = em.find(Student.class, id);
		if(this.student == null)
		{
			System.out.println("Student with ID: "+id+" not Found");
			return "Failure";
		}
		else
			{
				et.begin(); //begin transaction as DML
				this.student.setName(student.getName());
				this.student.setAddress(student.getAddress());
				em.persist(this.student);
				et.commit();
				return "Success";
			}
			
		}
		
		catch(Exception e) {
			if(et!=null)
				et.rollback();
			e.printStackTrace();
			return "Failure";
		}
		
		finally {
			em.close();
		}
	}

	@Override
	public String deleteStudent(int id) {
		
		em = ENTITY_MANAGER_FACTORY.createEntityManager();
		et = em.getTransaction();
		try {
		this.student = em.find(Student.class, id);
		if(this.student == null) 
			{
			System.out.println("Student with ID: "+id+" not present.");
			return "Failure";
			}
			
		else {
			et.begin(); //begin transaction as DML
			em.remove(this.student);
			et.commit();
			return "Success";
		}
		}
		catch(Exception e) {
			if(et!=null) 
				et.rollback();
			e.printStackTrace();
			return "Failure";
		}
		
		finally {
			em.close();
		}
	}

}
