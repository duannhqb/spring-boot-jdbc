package edu.poly.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.poly.spring.dao.HobbyDao;
import edu.poly.spring.model.Hobby;
import edu.poly.spring.service.HobbyService;

@Service
@Transactional
public class HobbyServiceImpl implements HobbyService{

	@Autowired
	private HobbyDao hobbyDao;
	
	@Override
	public void addHobby(Hobby hobby) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHobby(Hobby hobby) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeHobby(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hobby getHobbyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hobby> getAllHobbies() {
		// TODO Auto-generated method stub
		return hobbyDao.getAllHobbies();
	}

}
