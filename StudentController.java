package com.jspider.jdbc_prepared_curd_architecture.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_curd_architecture.dao.StudentDao;
import com.jspider.jdbc_prepared_curd_architecture.dto.StudentDto;
import com.jspider.jdbc_prepared_curd_architecture.service.StudentService;


public class StudentController {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StudentService servic=new StudentService();
		while(true) {
			
			System.out.println("1.Insert\n 2. Delete\n 3. Udate\n 4.Display\n 5.Exit");
			System.out.println("select your option");
			
			int option = scn.nextInt();
			switch(option) {
			case 1:{
				System.out.println("Enter student id");
				int id = scn.nextInt();
				
				System.out.println("Enter student name");
				String name = scn.next();
				
				System.out.println("Enter student email");
				String email = scn.next();
				
				System.out.println("Enter student phone");
				long phone = scn.nextLong();
				
				StudentDto studen =new StudentDto(id, name, email, phone);
				StudentDto sd = servic.saveStudentService(studen);
				
			}
			break;
			
			case 2:{
				
				System.out.println("Enter student id");
				int id = scn.nextInt();
				StudentDto student = servic.getStudentByIdService(id);
				
				if(student != null) {
					System.out.println(student);
				}else {
					System.err.println("given id is not found");
				}
			}
			break;
			
			case 3:{
				System.out.println("Enter student id ");
				int id = scn.nextInt();
				
				System.out.println("Enter student name");
				String name = scn.nextLine();
				
				int a = servic.getUpdateStudentNameByIdService(id, name);
				if(a==1) {
					System.out.println("updated...data");
				}else {
					System.out.println("id is not found");
				}
			
			}
			break;
			
			case 4:{
				List<StudentDto> lst = servic.getAllStudentByService();
				
				if(lst != null) {
					
					System.out.println(lst);
				}else {
					System.out.println("there are something data base connectivity with code check");
				}
			}
			}
		}
	}

}
