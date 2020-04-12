package com.draganatasevska.finki.prowork.web.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Holder object for all user data.
 */
@Entity
@Data
@RequiredArgsConstructor
@Table(name="user")
public class User {
    @Id
    @Column
    @ApiModelProperty(notes = "Dragana")
    private String username;

    @Column
    private String password;

    @Column(unique = true)
    private String email;

    @Column
    private Date dateCreated;

    @Column
    private String resetToken;

    @JsonIgnore
    @OneToMany(mappedBy = "createdBy")
    private Set<Issue> createdIssues;

    @JsonIgnore
    @OneToMany(mappedBy = "reviewedBy")
    private Set<Issue> reviewingIssues;

    @JsonIgnore
    @OneToMany(mappedBy = "assignedTo")
    private Set<Issue> assignedIssues;

    @JsonIgnore
    @OneToMany(mappedBy = "commentedBy")
    private Set<Comment> comments;
}
