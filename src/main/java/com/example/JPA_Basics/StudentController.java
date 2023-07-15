package com.example.JPA_Basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String Response = studentService.addStudent(student);
        return new ResponseEntity(Response, HttpStatus.CREATED);
    }
    @GetMapping("/get-student-by-id")
    public ResponseEntity getStudentById(@RequestParam("id") int rollNo){
        Student student = studentService.getStudentById(rollNo);
        if(student == null){
            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student, HttpStatus.FOUND);
    }
}
