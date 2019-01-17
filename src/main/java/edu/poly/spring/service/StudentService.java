package edu.poly.spring.service;

import java.util.List;

import edu.poly.spring.model.Student;

public interface StudentService {
	public void addStudent(Student student);

	public void updateStudent(Student student);

	public void removeStudent(int id);

	public Student getStudentById(int id);

	public List<Student> getAllStudents();
}
