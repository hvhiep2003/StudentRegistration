package com.example.StudentRegistration.repository;

import com.example.StudentRegistration.entity.Register;
import com.example.StudentRegistration.entity.Student;
import com.example.StudentRegistration.entity.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    boolean existsByStudentAndSubjectClass(Student student, SubjectClass subjectClass);
}
