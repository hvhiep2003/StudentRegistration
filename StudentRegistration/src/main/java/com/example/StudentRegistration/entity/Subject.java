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
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectCode;
    private String name;
    private int credit;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<SubjectClass> subjectClasses;
}
