package com.StudentMarks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentMarks.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	//List<Teacher> findByNameContainingIgnoreCase(String keyword);
}
