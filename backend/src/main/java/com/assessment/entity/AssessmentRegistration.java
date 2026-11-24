package com.assessment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assessment_registrations")
@Getter
@Setter
@NoArgsConstructor
public class AssessmentRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeId;      // which employee registered

    @Column(nullable = false)
    private String assessmentName;

    @Column(nullable = false)
    private String assessmentType;  // for example Technical or Behavioural

    @Column(nullable = false)
    private LocalDate startDate;    // LocalDate = date only, no time

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private String status;          // we will set "REGISTERED"

    private LocalDateTime registeredAt;   // when the record was created

    @PrePersist                     // runs automatically just before the first save
    void onCreate() {
        registeredAt = LocalDateTime.now();
    }
}