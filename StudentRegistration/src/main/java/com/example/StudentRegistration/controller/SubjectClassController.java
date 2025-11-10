package com.example.StudentRegistration.controller;

import com.example.StudentRegistration.entity.SubjectClass;
import com.example.StudentRegistration.service.SubjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectClassController {
    @Autowired
    private SubjectClassService subjectClassService;

    @GetMapping("/{semesterId}")
    public List<SubjectClass> getSubjectsBySemester(@PathVariable Long semesterId) {
        return subjectClassService.getSubjectClassesBySemesterId(semesterId);
    }

}
