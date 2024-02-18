package com.StudentMarks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.StudentMarks.entity.Marks;




public interface MarksRepository extends JpaRepository<Marks, Integer> {
	
	/*@Query("SELECT new com.StudentMarks.model.StudentSubjectMarksDTO(m.student.studentId, m.student.name, m.semester, m.subject, m.marks) " +
            "FROM Marks m WHERE m.subject = :subject")
    List<StudentSubjectMarksDTO> getAllStudents(String subject);*/
	
	
	
	
	//List<Marks> findBySubject(String subject);
	
	List<Marks> findByStudentId(Integer studentId);

	
	}

