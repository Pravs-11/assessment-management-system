package com.assessment.repository;

import com.assessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<User, Long> means "manage User objects whose primary key is a Long".
// It gives us save(), findAll(), findById(), deleteById() and more, with no code from us.
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring reads the method NAME and writes the SQL:
    // SELECT * FROM users WHERE employee_id = ?
    // Optional means "the user may or may not exist"
    Optional<User> findByEmployeeId(String employeeId);

    // true if a user with this employee ID already exists
    boolean existsByEmployeeId(String employeeId);

    // true if this email is already used
    boolean existsByEmail(String email);
}