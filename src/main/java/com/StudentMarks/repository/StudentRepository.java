package com.StudentMarks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.StudentMarks.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	 //List<Student> findByNameContainingIgnoreCase(String keyword);
	 
	 

	}
	 
