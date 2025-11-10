package com.example.StudentRegistration.service;

import com.example.StudentRegistration.entity.Semester;
import com.example.StudentRegistration.repository.SemesterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Semester getActiveSemester() {
        List<Semester> semesters = semesterRepository.findAll();
        for (Semester semester : semesters) {
            if (semester.getIsActive() != null && semester.getIsActive()) {
                return semester;
            }
        }
        return null;
    }
}
