package com.jspider.jdbc_prepared_curd_architecture.service;

import java.util.List;

import com.jspider.jdbc_prepared_curd_architecture.dao.StudentDao;
import com.jspider.jdbc_prepared_curd_architecture.dto.StudentDto;

public class StudentService {
	
	StudentDao dao = new StudentDao();
	
	public StudentDto saveStudentService(StudentDto student) {
		
		int id = student.getId();
		if(id<1000) {
		return dao.saveStudentDao(student);
		}else {
			System.out.println("please pass id with 3 digit or less than");
			return null;
		}
	}
	
	public StudentDto getStudentByIdService(int studentId) {
		
		return dao.getStudentById(studentId);
	}
	
	public List<StudentDto> getAllStudentByService(){
		
		return dao.getAllStudent();
	}
	
	public int getUpdateStudentNameByIdService(int id, String name) {
		return dao.getUpdateStudentNameByIdDao(id, name);
	}
	public int getUpdateStudentEmailAndPhoneByIdService(int id, String email, long phone) {
	
		return dao.getUpdateStudentNameAndEmailByIdDao(id, email, phone);
	}
	
	public int getStudentDeleteByIdService(int id) {
		
		return dao.getStudentByIdDelete(id); 
	}

}
