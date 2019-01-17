package edu.poly.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.poly.spring.dao.StudentDao;
import edu.poly.spring.model.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Student (name, email, hobby, phone, gender, avatar) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getHobby(), student.getPhone(),
				student.getGender(), student.getAvatar());
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Student SET name = ?, email = ?, hobby = ?, phone = ?, gender = ?, avatar = ? WHERE id = ?";
		jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getHobby(), student.getPhone(),
				student.getGender(), student.getAvatar(), student.getId());
	}

	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Student WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setAvatar(rs.getString("avatar"));
				student.setGender(rs.getString("gender"));
				student.setHobby(rs.getString("hobby"));
				student.setPhone(rs.getString("phone"));
				
				return student;
			}
		});
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Student";
		
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setAvatar(rs.getString("avatar"));
				student.setGender(rs.getString("gender"));
				student.setHobby(rs.getString("hobby"));
				student.setPhone(rs.getString("phone"));
				
				return student;
			}
		});
	}

}
