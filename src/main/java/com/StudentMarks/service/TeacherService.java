package com.StudentMarks.service;

import java.util.List;
import java.util.Optional;


import com.StudentMarks.entity.Teacher;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Integer id);
    Teacher updateTeacher(Integer id, Teacher teacher);
	Teacher createTeacher(Teacher teacher);
	boolean deleteTeacher(Integer id);
}


