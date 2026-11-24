package com.assessment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity                      // this class becomes a database table
@Table(name = "users")       // table name (we avoid "user", a reserved word in some databases)
@Getter                      // Lombok writes the getters for us
@Setter                      // Lombok writes the setters for us
@NoArgsConstructor           // Lombok writes an empty constructor (JPA needs one)
public class User {

    @Id                                                  // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // MySQL auto-increments it
    private Long id;

    @Column(nullable = false, unique = true)  // required, and no two users can share it
    private String employeeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;      // later we store the encrypted (BCrypt) password here

    @Enumerated(EnumType.STRING)  // saves "ADMIN" / "EMPLOYEE" as text
    @Column(nullable = false)
    private Role role;
}