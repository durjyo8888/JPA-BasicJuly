package com.example.JPA_Basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "student added successfully";
    }

    public Student getStudentById(int rollNo) {
        Optional<Student> optionalStudent = studentRepository.findById(rollNo);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        return null;
    }
}
