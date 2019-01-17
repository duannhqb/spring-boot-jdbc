package edu.poly.spring.dao;

import java.util.List;

import edu.poly.spring.model.Hobby;

public interface HobbyDao {
	public void AddHobby(Hobby hobby);
	
	public List<Hobby> getAllHobbies();
	
}
