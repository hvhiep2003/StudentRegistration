package com.example.StudentRegistration.controller;

import com.example.StudentRegistration.entity.Semester;
import com.example.StudentRegistration.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semesters")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @GetMapping
    public List<Semester> getAllSemesters() {
        return semesterService.getAllSemesters();
    }
}
