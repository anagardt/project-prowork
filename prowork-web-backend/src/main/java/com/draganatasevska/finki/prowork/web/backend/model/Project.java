package com.draganatasevska.finki.prowork.web.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private Set<Issue> issues;
}

