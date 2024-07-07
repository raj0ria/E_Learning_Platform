package com.rajoria.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "author_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "course")
    List<Section> sections = new ArrayList<>();

    private String name;

    private String description;


}
