package com.example.JPA_Basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public String deleteStudentById(int rollNo) {
        studentRepository.deleteById(rollNo);
        return "Student delete successfully";
    }

    public String UpdateAgeById(int age, int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()){
            optionalStudent.get().setAge(age);
        }
        return "Student age Updated successfully";
    }

    public List<Student> GetAllStudentAgeGreaterThenX(int x) {
        List<Student> studentList = studentRepository.findAll();
        List<Student> students = new ArrayList<>();

        for(Student student : studentList){
            if(student.getAge() >= x){
                students.add(student);
            }
        }
        return students;
    }

    public String deleteAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        if(studentList.size() == 0){
            return null;
        }
        studentRepository.deleteAll();
        return "All Students delete successfully";
    }
}
