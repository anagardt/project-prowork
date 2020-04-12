package com.draganatasevska.finki.prowork.web.backend.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Holder object for all comment data.
 */
@Entity
@Data
@RequiredArgsConstructor
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Issue issue;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User commentedBy;

    @Column(length = 1000, nullable = false)
    private String commentText;
}
