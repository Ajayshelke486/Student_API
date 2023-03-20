package com.ty.BB_APK.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.BB_APK.dto.Student;
import com.ty.BB_APK.repository.Student_Repo;

@Repository
public class Student_dao {

	@Autowired
	private Student_Repo repo;

	public void saveStudent(Student student) {
		repo.save(student);
	}

	public List<Student> createBulkStudents(List<Student> student) {

		return repo.saveAll(student);
	}

	public Optional<Student> getStudentById(int id) {
		return repo.findById(id);
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public List<Student> searchStudentsByName(String name) {
		return repo.findByNameStartingWith(name);
	}

	public Student updateStudentById(int id, Student student) {
		Optional<Student> existingUser = repo.findById(id);
		if (existingUser.isPresent()) {
			Student updatedStudent = existingUser.get();
			updatedStudent.setName(student.getName());
			updatedStudent.setEmail(student.getEmail());
			return repo.save(updatedStudent);
		} else {
			return null;
		}
	}

	public List<Student> updateBulkStudents(List<Student> students) {
		return repo.saveAll(students);
	}

	public void deleteStudentById(int id) {
		repo.deleteById(id);
	}

	public void deleteBulkStudents(List<Student> students) {
		repo.deleteAll(students);
	}

}
