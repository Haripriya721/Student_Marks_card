package com.StudentMarks.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentMarks.entity.Student;
import com.StudentMarks.exception.ResourceNotFoundException;
import com.StudentMarks.repository.StudentRepository;
import com.StudentMarks.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(student.getName());
            existingStudent.setContact(student.getContact());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setEnrollYear(student.getEnrollYear());
            return studentRepository.save(existingStudent);
        } else {
        	throw new ResourceNotFoundException("Student not found");
        }
    }

    @Override
    public boolean deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}