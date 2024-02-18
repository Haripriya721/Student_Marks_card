package com.StudentMarks.service;

import java.util.List;
import java.util.Optional;

import com.StudentMarks.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student updateStudent(Integer id, Student student);
	Student createStudent(Student student);
	boolean deleteStudent(Integer id);
}
