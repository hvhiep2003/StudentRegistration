package com.example.StudentRegistration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject_class")
public class SubjectClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sectionCode;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    private String teacher;
    private String room;
    private String schedule;
    private String session;
    private int capacity;
    private int registeredCount = 0;
    private Boolean openForRegister = true;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;
    @OneToMany(mappedBy = "subjectClass", cascade = CascadeType.ALL)
    private List<Register> registrations;


}
