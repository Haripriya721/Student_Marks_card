package com.StudentMarks.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentMarks.entity.Teacher;
import com.StudentMarks.exception.ResourceNotFoundException;
import com.StudentMarks.repository.TeacherRepository;
import com.StudentMarks.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        return optionalTeacher.orElse(null);
    }

    @Override
    public Teacher updateTeacher(Integer id, Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher existingTeacher = optionalTeacher.get();
            existingTeacher.setName(teacher.getName());
            existingTeacher.setContact(teacher.getContact());
            existingTeacher.setEmail(teacher.getEmail());
            existingTeacher.setSubject(teacher.getSubject());
            return teacherRepository.save(existingTeacher);
        } else {
            throw new ResourceNotFoundException("Teacher not found", "Teacher", "id", id);
        }
    }

    @Override
    public boolean deleteTeacher(Integer id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            teacherRepository.delete(optionalTeacher.get());
            return true;
        } else {
            throw new ResourceNotFoundException("Teacher not found", "Teacher", "id", id);
        }
    }
}