package com.ty.BB_APK.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BB_APK.dao.Student_dao;
import com.ty.BB_APK.dto.Student;

@RestController
@RequestMapping("/users")
public class Student_controller {

	@Autowired
	private Student_dao dao;

	// insert user
	@PostMapping("/save")
	public void saveStudent(@RequestBody Student student) {

		dao.saveStudent(student);
	}

	// Insert users in bulk
	@PostMapping("/bulk")
	public List<Student> createBulk(@RequestBody List<Student> student) {
		return dao.createBulkStudents(student);
	}

	// Get a user by id
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable int id, @RequestBody Student student) {
		return dao.getStudentById(id);
	}

	// Get all users
	@GetMapping("getusers")
	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}

	// Search users by name
	@GetMapping("/search")
	public List<Student> searchStudentsByName(@RequestParam String name) {
		return dao.searchStudentsByName(name);
	}

	// Update a user by id
	@PutMapping("/{id}")
	public Student updateStudentById(@PathVariable int id, @RequestBody Student student) {
		return dao.updateStudentById(id, student);
	}

	// Update multiple users
	@PutMapping("/bulk")
	public List<Student> updateBulkStudents(@RequestBody List<Student> students) {
		return dao.updateBulkStudents(students);
	}

	// Delete a user by id
	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable int id) {
		dao.deleteStudentById(id);
	}

	// Delete multiple users
	@DeleteMapping("/bulk")
	public void deleteBulkStudents(@RequestBody List<Student> students) {
		dao.deleteBulkStudents(students);
	}

}
