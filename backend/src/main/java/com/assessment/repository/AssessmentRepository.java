package com.assessment.repository;

import com.assessment.entity.AssessmentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AssessmentRepository extends JpaRepository<AssessmentRegistration, Long> {

    // One employee's registrations, newest start date first
    List<AssessmentRegistration> findByEmployeeIdOrderByStartDateDesc(String employeeId);

    // Used to stop the same employee registering twice for the same assessment on the same date
    boolean existsByEmployeeIdAndAssessmentNameAndStartDate(
            String employeeId, String assessmentName, LocalDate startDate);
}