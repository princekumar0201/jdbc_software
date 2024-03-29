package com.jspider.jdbc_prepared_curd_architecture.dto;

/**
 * 
 * @author Prince kumar
 * 
 * this is our student encapsulation class which has id, name, email, phone
 * with student dto
 *
 */
public class StudentDto {
	
	private int id;
	private String name;
	private String email;
	private long phone;
	
	
	public StudentDto() {
		super();
	}
	
	public StudentDto(int id, String name, String email, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
