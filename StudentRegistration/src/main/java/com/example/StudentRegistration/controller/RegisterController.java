package com.example.StudentRegistration.controller;

import com.example.StudentRegistration.entity.Student;
import com.example.StudentRegistration.entity.SubjectClass;
import com.example.StudentRegistration.repository.StudentRepository;
import com.example.StudentRegistration.repository.SubjectClassRepository;
import com.example.StudentRegistration.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectClassRepository subjectClassRepository;

    @PostMapping
    public String registerSubject(@RequestParam Long studentId,
                                  @RequestParam Long subjectClassId) {
        return registerService.registerSubject(studentId, subjectClassId);
    }

}

