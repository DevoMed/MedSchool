package com.example.MedSchool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MedSchool.entities.Student;
import com.example.MedSchool.entities.Subject;
import com.example.MedSchool.entities.Teacher;
import com.example.MedSchool.repositories.StudentRepository;
import com.example.MedSchool.repositories.SubjectRepository;
import com.example.MedSchool.repositories.TeacherRepository;

@RestController
@RequestMapping("subjects")
public class SubjectController {

	

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable String subjectId,
            @PathVariable String studentId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.students.add(student);
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacherToSubject(
            @PathVariable String subjectId,
            @PathVariable String teacherId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.teachers.add(teacher);
        return subjectRepository.save(subject);
    }
}
