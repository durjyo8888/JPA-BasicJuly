package com.example.JPA_Basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping("/delete-by-id")
    public ResponseEntity deleteStudentById(@RequestParam int rollNo){
        String deleteId = studentService.deleteStudentById(rollNo);
        return new ResponseEntity(deleteId,HttpStatus.OK);
    }
    @PutMapping("/update-age")
    public ResponseEntity UpdateAgeById(@RequestParam("age") int age,@RequestParam("id") int Id){
        String student = studentService.UpdateAgeById(age, Id);
        return new ResponseEntity(student, HttpStatus.OK);
    }
    @GetMapping("/get-all-student-greater-then-x")
    public ResponseEntity GetAllStudentAgeGreaterThenX(@RequestParam int x){
        List<Student> student = studentService.GetAllStudentAgeGreaterThenX(x);
        return new ResponseEntity(student, HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity deleteAllStudent(){
        String student = studentService.deleteAllStudent();
        if(student == null){
            return new ResponseEntity("Students not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student, HttpStatus.OK);
    }
}
