package com.example.StudentRegistration.service;

import com.example.StudentRegistration.entity.Subject;
import com.example.StudentRegistration.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

}
