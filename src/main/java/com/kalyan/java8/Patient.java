package com.kalyan.java8;

public class Patient {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String condition;
	private double weight;
	private int height; // in cm
	private String doctor;

	public Patient(int id, String name, int age, String gender, String condition, double weight, int height,
			String doctor) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.condition = condition;
		this.weight = weight;
		this.height = height;
		this.doctor = doctor;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", condition="
				+ condition + ", weight=" + weight + ", height=" + height + ", doctor=" + doctor + "]";
	}

}
