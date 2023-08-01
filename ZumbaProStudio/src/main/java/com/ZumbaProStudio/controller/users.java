package com.ZumbaProStudio.controller;

public class users {
	//Attributes
	public int id;
	public String fname;
	public String lname;
	public int age;
	public String gender;
	public String email;
	public String address;
	public String city;
	public String zipcode;
	public String phone;
	public String password;
	
	public users() {
		
	}
	
	public users(int id, String fname, String lname, int age, String gender, String email, String address, String city, String zipcode, String phone, String password) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "users [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", gender=" + gender + ", age=" + age + ", email=" + email + ", address=" + address + ", city=" + city + ", zipcode=" + zipcode + ", phone=" + phone + ", password=" + password +"]";
	}

}
