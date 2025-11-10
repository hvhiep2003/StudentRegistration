package com.example.StudentRegistration.repository;

import com.example.StudentRegistration.entity.Semester;
import com.example.StudentRegistration.entity.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectClassRepository extends JpaRepository<SubjectClass, Long> {
    List<SubjectClass> findBySemester(Semester semester);
}
