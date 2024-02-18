package com.StudentMarks.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.StudentMarks.entity.Marks;
import com.StudentMarks.entity.Student;
import com.StudentMarks.exception.ResourceNotFoundException;

import com.StudentMarks.repository.MarksRepository;
import com.StudentMarks.repository.StudentRepository;
import com.StudentMarks.service.MarksService;



@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public Marks createMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @Override
    public List<Marks> getMarksByStudentId(Integer id) {
        return marksRepository.findByStudentId(id);
    }

    @Override
    public Marks updateMarks(Integer id, Marks marks) {
        Marks existingMarks = marksRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Marks", "id", id.toString()));
        existingMarks.setScore(marks.getScore());
        existingMarks.setSubject(marks.getSubject());
        existingMarks.setSemester(marks.getSemester());
        return marksRepository.save(existingMarks);
    }

    @Override
    public boolean deleteMarksByStudentId(Integer id) {
        List<Marks> marks = marksRepository.findByStudentId(id);
        if (!marks.isEmpty()) {
            marksRepository.deleteAll(marks);
            return true;
        } else {
            throw new ResourceNotFoundException("Marks", "studentId", id.toString());
        }
    }

}