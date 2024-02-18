package com.StudentMarks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentMarks.entity.Marks;

import com.StudentMarks.service.MarksService;


@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;
    
    @PostMapping("/createMarks")
    public ResponseEntity<Marks> createMarks(@RequestBody Marks marks) {
        Marks createdMarks = marksService.createMarks(marks);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMarks);
    }
    
    
    @GetMapping("/getMarks")
    public ResponseEntity<List<Marks>> getAllMarks() {
        List<Marks> marks = marksService.getAllMarks();
        return ResponseEntity.ok(marks);
    }
    
    
    @GetMapping("/getMarks/{id}")
    public ResponseEntity<List<Marks>> getMarksByStudentId(@PathVariable Integer id) {
        List<Marks> marks = marksService.getMarksByStudentId(id);
        if (!marks.isEmpty()) {
            return ResponseEntity.ok(marks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PutMapping("/updateMarks/{id}")
    public ResponseEntity<Marks> updateMarks(@PathVariable Integer id, @RequestBody Marks marks) {
        Marks updatedMarks = marksService.updateMarks(id, marks);
        if (updatedMarks != null) {
            return ResponseEntity.ok(updatedMarks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @DeleteMapping("/deleteMarks/{id}")
    public ResponseEntity<Void> deleteMarksByStudentId(@PathVariable Integer id) {
        boolean deleted = marksService.deleteMarksByStudentId(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    
}
