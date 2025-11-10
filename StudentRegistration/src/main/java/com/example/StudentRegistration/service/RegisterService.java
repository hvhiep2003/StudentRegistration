package com.example.StudentRegistration.service;

import com.example.StudentRegistration.entity.Register;
import com.example.StudentRegistration.entity.Student;
import com.example.StudentRegistration.entity.SubjectClass;
import com.example.StudentRegistration.repository.RegisterRepository;
import com.example.StudentRegistration.repository.StudentRepository;
import com.example.StudentRegistration.repository.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class RegisterService {
    @Autowired
    private  RegisterRepository registerRepository;
    @Autowired
    private  StudentRepository studentRepository;
    @Autowired
    private SubjectClassRepository subjectClassRepository;

    public String registerSubject(Long studentId, Long subjectClassId) {
        Student student = studentRepository.findById(studentId).get();
        SubjectClass subjectClass = subjectClassRepository.findById(subjectClassId).get();

        if (subjectClass.getRegisteredCount() >= subjectClass.getCapacity()) {
            return "Lớp học phần đã đầy, vui lòng chọn lớp khác.";
        }
        boolean alreadyRegistered = registerRepository.existsByStudentAndSubjectClass(student, subjectClass);
        if (alreadyRegistered) {
            return "Sinh viên đã đăng ký môn này trước đó.";
        }

        Register register = new Register();
        register.setStudent(student);
        register.setSubjectClass(subjectClass);
        register.setRegistrationDate(LocalDateTime.now());
        registerRepository.save(register);

        subjectClass.setRegisteredCount(subjectClass.getRegisteredCount() + 1);
        subjectClassRepository.save(subjectClass);
        return "Đăng ký thành công cho sinh viên ";
    }
}
