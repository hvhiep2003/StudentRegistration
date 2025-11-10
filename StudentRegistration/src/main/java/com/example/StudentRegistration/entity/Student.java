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
@Table(name = "student")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String studentCode;
        private String fullName;
        private String className;
        private String email;
        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Register> registrations;

}
