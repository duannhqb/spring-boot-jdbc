package edu.poly.spring.model;

public class Hobby {
	private int id;
	private String hobby;

	public Hobby() {
		// TODO Auto-generated constructor stub
	}

	public Hobby(int id, String hobby) {
		super();
		this.id = id;
		this.hobby = hobby;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
