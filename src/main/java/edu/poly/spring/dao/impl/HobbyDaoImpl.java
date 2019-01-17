package edu.poly.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.poly.spring.dao.HobbyDao;
import edu.poly.spring.model.Hobby;

@Repository
@Transactional
public class HobbyDaoImpl implements HobbyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Hobby> getAllHobbies() {
		String sql = "SELECT * FROM Hobby";

		return jdbcTemplate.query(sql, new RowMapper<Hobby>() {
			@Override
			public Hobby mapRow(ResultSet rs, int rowNum) throws SQLException {
				Hobby hobby = new Hobby();
				hobby.setId(rs.getInt(1));
				hobby.setHobby(rs.getString(2));

				return hobby;
			}
		});
	}

	@Override
	public void AddHobby(Hobby hobby) {
		// TODO Auto-generated method stub

	}

}
