package com.rahul.entity;

import javax.peristence.Entity;

@Entity
@Table(name="students")
public class Student {
	
	private Integer id;
	private String name;
	private Integer age;
	private String city;
	
	public Student()
	{	
		System.out.println("No-args Constructor required for internal use of hibernate");
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getAge() {
		return age;
	}
	
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public String getCity() {
		return city;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}


}
