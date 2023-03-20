package com.ty.BB_APK.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.BB_APK.dto.Student;

public interface Student_Repo extends JpaRepository<Student, Integer> {

	 List<Student> findByNameStartingWith(String name);

	
}
