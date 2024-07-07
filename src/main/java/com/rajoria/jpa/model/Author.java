package com.rajoria.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(mappedBy = "authors")
    private Set<Course> courses = new HashSet<>();

    @Column(name = "first_name")
    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false) //by default this is 'true'
    private String email;

    private int age;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime lastModified;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now();}

    @PreUpdate
    protected void onUpdate() { lastModified = LocalDateTime.now();}


}
