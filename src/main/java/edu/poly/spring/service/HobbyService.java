package edu.poly.spring.service;

import java.util.List;

import edu.poly.spring.model.Hobby;

public interface HobbyService {
	public void addHobby(Hobby hobby);

	public void updateHobby(Hobby hobby);

	public void removeHobby(int id);

	public Hobby getHobbyById(int id);

	public List<Hobby> getAllHobbies();
}
