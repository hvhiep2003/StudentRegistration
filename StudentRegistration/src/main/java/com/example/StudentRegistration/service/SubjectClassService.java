package com.example.StudentRegistration.service;

import com.example.StudentRegistration.entity.Semester;
import com.example.StudentRegistration.entity.SubjectClass;
import com.example.StudentRegistration.repository.SemesterRepository;
import com.example.StudentRegistration.repository.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectClassService {
    @Autowired
    private SubjectClassRepository subjectClassRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    public List<SubjectClass> getSubjectClassesBySemesterId(Long semesterId) {
        Optional<Semester> optionalSemester = semesterRepository.findById(semesterId);
        if (!optionalSemester.isPresent()) {
            throw new RuntimeException("Không tìm thấy kỳ học ");
        }
        Semester semester = optionalSemester.get();
        return subjectClassRepository.findBySemester(semester);
    }


}
