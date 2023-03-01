package com.filters;

public class Student {

	private long id;
	private String name;
	private double marks;
	private String email;

	public Student() {
		super();
	}

	public Student(long id, String name, double marks, String email) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", email=" + email + "]";
	}

	public Student(long id, String name, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

}
