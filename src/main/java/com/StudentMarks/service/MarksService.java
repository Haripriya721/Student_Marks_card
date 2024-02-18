package com.StudentMarks.service;

import java.util.List;
import java.util.Map;

import com.StudentMarks.entity.Marks;





public interface MarksService {
	List<Marks> getAllMarks();
	Marks createMarks(Marks marks);
	List<Marks> getMarksByStudentId(Integer id);
	Marks updateMarks(Integer id, Marks marks);
	boolean deleteMarksByStudentId(Integer id);
}
