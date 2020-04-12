package com.draganatasevska.finki.prowork.web.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Holder object for all issue data.
 */
@Entity
@RequiredArgsConstructor
@Data
@Table(name="issue")
public class Issue {
    public enum issueStatus {
        TO_DO, IN_PROGRESS, DONE
    }

    public enum issueType {
        TASK, STORY, BUG
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long issueId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private issueStatus status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private issueType type;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Project project;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User createdBy;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User reviewedBy;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User assignedTo;

    @Column(nullable = false)
    private Date dateCreated;

    @Column
    private Date dateDue;

    @Column(length = 1000, nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "issue", cascade = CascadeType.REMOVE)
    private Set<Comment> comments;

}
