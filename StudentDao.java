package com.jspider.jdbc_prepared_curd_architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_prepared_curd_architecture.connection.StudentConnection;
import com.jspider.jdbc_prepared_curd_architecture.dto.StudentDto;

/**
 * 
 * @author prince kumar
 * 
 * this class will communicate with mysql
 *
 */

public class StudentDao {
	
	Connection conn = StudentConnection.getStudentConnection();
	public StudentDto saveStudentDao(StudentDto student) {
		
		String inserQuery = "insert into studentdto values(?,?,?,?)";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(inserQuery);
			
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setLong(4, student.getPhone());
			
			ps.execute();
			return student;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public StudentDto getStudentById(int studentId) {
		
		String selectQuery = "select * from studentdto where id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			ps.setInt(1, studentId);
			
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("Email");
				long phone = rs.getLong("phone");
				
				return new StudentDto(id,name,email,phone);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
public List<StudentDto> getAllStudent() {
		
		String selectQuery = "select * from studentdto ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			
			List<StudentDto> lst = new ArrayList<StudentDto>();
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");
				
				StudentDto student = new StudentDto(id,name,email,phone);
				lst.add(student);
			}
			return lst;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    public int  getUpdateStudentNameByIdDao(int id , String name) {
    	
    	String updateQuery = "update studentdto set name=? where id=?";
    	
    	try {
			PreparedStatement ps = conn.prepareStatement(updateQuery);
			
			ps.setInt(2, id);
			ps.setString(1, name);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return 0;
    }
    
    public int getUpdateStudentNameAndEmailByIdDao(int id, String email, long phone) {
    	
    	String updateQuery = "update studentdto set email=?, phone=? where id =?";
    	
    	try {
			PreparedStatement ps = conn.prepareStatement(updateQuery);
			
			ps.setInt(3, id);
			ps.setString(1, email);
			ps.setLong(2, phone);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return 0;
    }
	
	public int getStudentByIdDelete(int id) {
		
		String deleteQuery = "delete from studentdto where id =?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(deleteQuery);
			
			ps.setInt(1, id);
			
			return ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
