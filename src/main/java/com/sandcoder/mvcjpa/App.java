package com.sandcoder.mvcjpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.sandcoder.controller.StudentController;
import com.sandcoder.controller.StudentControllerImpl;


public class App 
{
	private static StudentController studentController;
	private static String input;
	private static int id;
	private static String name;
	private static String address;
	
    public static void main( String[] args ) throws SQLException, IOException
    {
        while(true) {
        studentController = new StudentControllerImpl();
        System.out.println("Select an Option from Below: ");
        System.out.println("1. Show All Students ");
        System.out.println("2. Show One Student ");
        System.out.println("3. Create One Student ");
        System.out.println("4. Update One Student ");
        System.out.println("5. Delete One Student ");
        System.out.println("6. Exit ");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine();
        
        
        switch(Integer.parseInt(input)) {
        case 1: studentController.getStudents();
        break;
        
        case 2: {
        	System.out.println("Enter the ID: ");
        	input = reader.readLine();
        	studentController.getStudent(Integer.parseInt(input));
        }
        break;
        
        case 3:{
        	System.out.println("Enter ID: ");
        	input = reader.readLine();
        	id = Integer.parseInt(input);
        	System.out.println("Enter Name: ");
        	input = reader.readLine();
        	name = input;
        	System.out.println("Enter Address: ");
        	input = reader.readLine();
        	address = input;
        	studentController.addStudent(id,name,address);
        }
        break;
        
        case 4:{
        	System.out.println("Enter ID: ");
        	input = reader.readLine();
        	id = Integer.parseInt(input);
        	System.out.println("Enter Name (Leave Empty to Skip): ");
        	input = reader.readLine();
        	name = input;
        	System.out.println("Enter Address: (Leave Empty to Skip)");
        	input = reader.readLine();
        	address = input;
        	studentController.updateStudent(id,name,address);
        	
        }
        break;
        case 5:{
        	System.out.println("Enter ID: ");
        	input = reader.readLine();
        	id = Integer.parseInt(input);
        	studentController.deleteStudent(id);
        	
        }
        break;
        
        case 6: {
        	System.out.println("Bye!");
        	System.exit(0);
        }
        break;
        
        default: System.out.println("Invalid Input");
        }
        }
        
    }
}
